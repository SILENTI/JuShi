package com.example.jushi.service.impl;

import com.example.jushi.mapper.OrderItemMapper;
import com.example.jushi.mapper.OrderMapper;
import com.example.jushi.model.*;
import com.example.jushi.service.IAddressService;
import com.example.jushi.service.IGoodsService;
import com.example.jushi.service.IOrderService;
import com.example.jushi.service.ITrolleyService;
import com.example.jushi.service.ex.InsertException;
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
    private IAddressService IAddressService;

    @Autowired
    private ITrolleyService ITrolleyService;

    @Autowired
    private IGoodsService IGoodsService;

    @Override
    public Order createOrder(Integer uid, Integer aid, Integer[] tid, String userName) {

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

//            System.out.println("商品总价："+price);

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

            if (sign == null || sign != 1){
                throw new InsertException("未知错误，插入失败");
            }
        }
        return order;
    }

    /**
     * 创建OrderItem
     * @param orderItem
     */
    @Override
    public void createOrderItem(OrderItem orderItem) {
            orderItemMapper.insertOrderItem(orderItem);
    }
}
