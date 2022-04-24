package com.example.jushi.service.impl;

import com.example.jushi.mapper.GoodsMapper;
import com.example.jushi.mapper.OrderItemMapper;
import com.example.jushi.mapper.OrderMapper;
import com.example.jushi.mapper.SeckillMapper;
import com.example.jushi.model.*;
import com.example.jushi.service.IAddressService;
import com.example.jushi.service.IGoodsService;
import com.example.jushi.service.IOrderService;
import com.example.jushi.service.ITrolleyService;
import com.example.jushi.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/13 17:28
 * Description: 订单相关业务层
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private IAddressService IAddressService;

    @Autowired
    private ITrolleyService ITrolleyService;

    @Autowired
    private IGoodsService IGoodsService;

    @Override
    public Order createOrderByTrolley(Integer uid, Integer aid, Integer[] tid, String userName) {

        //创建对象
        Order order = new Order();
        OrderItem orderItem = new OrderItem();

        //获取到address对象
        Address address = IAddressService.selectAddressByAid(aid, uid);

        //补全地址信息
        order.setCneeName(address.getName());
        order.setCneePhone(address.getPhone());
        order.setCneeProvince(address.getProvinceName());
        order.setCneeCity(address.getCityName());
        order.setCneeDistrict(address.getAreaName());
        order.setCneeAddress(address.getAddress());

        //获取到trolley对象-购物车对象
        List<Trolley> trolleys = ITrolleyService.selectTrolleyByTid(tid);

        BigDecimal price = null;
        //获取该商品表总价格
        for (Trolley trolley : trolleys) {
            //获取商品总价
            price = trolley.getPrice().multiply(new BigDecimal(trolley.getNum().toString()));
        }

            //设置商品总价
            order.setTotalPrices(price);

            //补全日志相关信息
            order.setUid(uid);
            order.setCreateUser(userName);
            order.setCreateTime(new Date());
            order.setModifUser(userName);
            order.setModifTime(new Date());
            order.setOrderTime(new Date());

            //新增数据后-获取到新增之后的主键ID oid
            Integer record = orderMapper.insertOrder(order);

            if (record == null || record !=1){
                throw new InsertException("位置情况数据新增失败");
            }

            //补全item信息 订单ID、
            orderItem.setOid(order.getOid());

            //补全Item日志相关信息
            orderItem.setCreateUser(userName);
            orderItem.setCreateTime(new Date());
            orderItem.setModifUser(userName);
            orderItem.setModifTime(new Date());

            //新增Item记录
        for (Trolley trolley : trolleys) {

            //获取good对象
            Goods goods = IGoodsService.selectGoodsByGid(trolley.getGid());

            //补全内容
            orderItem.setImage(goods.getgImg());
            orderItem.setTitle(goods.getgName());
            orderItem.setGid(trolley.getGid());
            orderItem.setPrice(trolley.getPrice());
            orderItem.setNum(trolley.getNum());

            //新增数据orderItem
            Integer sign = orderItemMapper.insertOrderItem(orderItem);

            //判断库存和购入量是否足够
            if ( (goods.getgStock() - trolley.getNum()) <0 ){
                throw new GoodsSoldOutException("商品售尽");
            }

            //修改商品库存
            modifyGoodsCount(goods.getgId(), goods.getgStock() - trolley.getNum() );

            if (sign == null || sign != 1){
                throw new InsertException("未知错误，插入失败");
            }
        }
        return order;
    }

    @Override
    public Order createOrderByGoods(Integer uid, Integer aid, Integer gid, Integer num, String userName) {

        //创建对象
        Order order = new Order();
        OrderItem orderItem = new OrderItem();

        //获取到address对象
        Address address = IAddressService.selectAddressByAid(aid, uid);

        //补全地址信息
        order.setCneeName(address.getName());
        order.setCneePhone(address.getPhone());
        order.setCneeProvince(address.getProvinceName());
        order.setCneeCity(address.getCityName());
        order.setCneeDistrict(address.getAreaName());
        order.setCneeAddress(address.getAddress());

        //获取商品的详细信息
        Goods goods = IGoodsService.selectGoodsByGid(gid);

        //获取商品的总价格
        BigDecimal price = goods.getgPrice().multiply(new BigDecimal(num.toString()));

        //存入Order对象
        order.setTotalPrices(price);

        //补全日志相关信息
        order.setUid(uid);
        order.setCreateUser(userName);
        order.setCreateTime(new Date());
        order.setModifUser(userName);
        order.setModifTime(new Date());
        order.setOrderTime(new Date());

        //新增数据后-获取到新增之后的主键ID oid
        Integer record = orderMapper.insertOrder(order);

        if (record == null || record !=1){
            throw new InsertException("位置情况数据新增失败");
        }

        //库存修改
        //判断库存和购入量是否足够
        if ( (goods.getgStock() - num) <0 ){
            throw new GoodsSoldOutException("商品售尽");
        }

        //修改商品库存
        modifyGoodsCount(goods.getgId(), goods.getgStock() - num );

        //补全item信息 订单ID、
        orderItem.setOid(order.getOid());

        //补全Item日志相关信息
        orderItem.setCreateUser(userName);
        orderItem.setCreateTime(new Date());
        orderItem.setModifUser(userName);
        orderItem.setModifTime(new Date());


        //Item补全内容
        orderItem.setImage(goods.getgImg());
        orderItem.setTitle(goods.getgName());
        orderItem.setGid(gid);
        orderItem.setPrice(price);
        orderItem.setNum(num);

        //新增数据orderItem
        Integer sign = orderItemMapper.insertOrderItem(orderItem);

        if (sign == null || sign != 1){
            throw new InsertException("未知错误，插入失败");
        }

        return order;
    }

    @Override
    public Order creatOrderBySeckill(Integer uid, Integer aid, Integer sid, Integer num, String userName) {
        //创建对象
        Order order = new Order();
        OrderItem orderItem = new OrderItem();

        //获取到address对象
        Address address = IAddressService.selectAddressByAid(aid, uid);

        //补全地址信息
        order.setCneeName(address.getName());
        order.setCneePhone(address.getPhone());
        order.setCneeProvince(address.getProvinceName());
        order.setCneeCity(address.getCityName());
        order.setCneeDistrict(address.getAreaName());
        order.setCneeAddress(address.getAddress());

        //获取秒杀表信息
        Seckill seckill = seckillMapper.selectSeckillBySid(sid);

        //获取商品的详细信息
        Goods goods = IGoodsService.selectGoodsByGid(seckill.getGid());

        //获取商品的总价格
        BigDecimal price = seckill.getPrice().multiply(new BigDecimal(num.toString()));

        //存入Order对象
        order.setTotalPrices(price);

        //补全日志相关信息
        order.setUid(uid);
        order.setCreateUser(userName);
        order.setCreateTime(new Date());
        order.setModifUser(userName);
        order.setModifTime(new Date());
        order.setOrderTime(new Date());

        //新增数据后-获取到新增之后的主键ID oid
        Integer record = orderMapper.insertOrder(order);

        if (record == null || record !=1){
            throw new InsertException("位置情况数据新增失败");
        }

        //库存修改
        //判断库存和购入量是否足够
        if ( (goods.getgStock() - num) <0 ){
            throw new SeckillGoodsSellOutException("秒杀商品售尽");
        }

        //修改商品库存
        modifySeckillCount(goods.getgId(), goods.getgStock() - num );

        //补全item信息 订单ID、
        orderItem.setOid(order.getOid());

        //补全Item日志相关信息
        orderItem.setCreateUser(userName);
        orderItem.setCreateTime(new Date());
        orderItem.setModifUser(userName);
        orderItem.setModifTime(new Date());


        //Item补全内容
        orderItem.setImage(goods.getgImg());
        orderItem.setTitle(goods.getgName());
        orderItem.setGid(seckill.getGid());
        orderItem.setPrice(price);
        orderItem.setNum(num);

        //新增数据orderItem
        Integer sign = orderItemMapper.insertOrderItem(orderItem);

        if (sign == null || sign != 1){
            throw new InsertException("未知错误，插入失败");
        }

        return order;
    }

    /**
     * 修改商品表商品库存
     * @param gid
     * @param count
     * @return
     */
    @Override
    public void modifyGoodsCount(Integer gid, Integer count) {

        Integer record = goodsMapper.updateGoodsNumByGid(gid, count);

        //若遇到未知问题，修改失败
        if (record == null || record!= 1){
            throw new UpdateException("数据修改失败");
        }
    }

    @Override
    public void modifySeckillCount(Integer sid, Integer count) {

        Integer record =  seckillMapper.updateSeckillNumBySid(sid, count);

        //若遇到未知问题，修改失败
        if (record == null || record!= 1){
            throw new UpdateException("数据修改失败");
        }
    }

    /**
     * 创建OrderItem
     * @param orderItem
     */
    @Override
    public void createOrderItem(OrderItem orderItem) {
        orderItemMapper.insertOrderItem(orderItem);
    }

    /**
     * 判断是否秒杀成功
     * @param user
     * @param sid
     * @return
     */
    @Override
    public boolean judgeSeckillOrder(User user, Integer sid) {

        //判断用户信息是否过期
        if (user == null){
            throw new UserLoginInfoExpiredException("用户登录信息过期");
        }

        //读取底层数据的查询是否含有符合该信息的订单
        Order order = orderMapper.selectOrderByUidAndSid(user.getUid(), sid);

        if (order == null){
            return false;
        }

        return true;
    }
}
