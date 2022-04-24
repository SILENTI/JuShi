package com.example.jushi.service.impl;

import com.example.jushi.mapper.GoodsMapper;
import com.example.jushi.mapper.OrderItemMapper;
import com.example.jushi.mapper.OrderMapper;
import com.example.jushi.model.Goods;
import com.example.jushi.model.Order;
import com.example.jushi.model.OrderItem;
import com.example.jushi.model.Seckill;
import com.example.jushi.mapper.SeckillMapper;
import com.example.jushi.service.IGoodsService;
import com.example.jushi.service.ISeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jushi.service.ex.SeckillGoodsExcessPurchaseQuantityException;
import com.example.jushi.service.ex.SeckillGoodsOverTimeException;
import com.example.jushi.service.ex.SeckillGoodsSellOutException;
import com.example.jushi.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022/03/19
 */
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill> implements ISeckillService {

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 秒杀商品展示
     * @return
     */
    @Override
    public List<SeckillGoodsVo> showSeckill() {
        return seckillMapper.selectAllSeckillGoodsVo();
    }

    /**
     * 秒杀条件判断
     * @param uid 用户ID
     * @param aid 收货地址ID
     * @param sid 秒杀ID
     * @param num
     * @param userName
     */
    @Override
    public void seckillJudge(Integer uid, Integer aid, Integer sid, Integer num, String userName) {

        Seckill seckill = seckillMapper.selectSeckillBySid(sid);
        //查询库存数量
        if (num>seckill.getCount()){
            //抛出异常-商品已售完
            throw new SeckillGoodsSellOutException("商品已销售完");
        }

        //确认是否在当前秒杀范围内
        LocalDateTime localDateTime = LocalDateTime.now();

        //若当前时间在秒杀开始之前或者在秒杀结束之后，就是不在秒杀范围内
        if (!seckill.getStartTime().isBefore(localDateTime)  || !seckill.getEndTime().isAfter(localDateTime)){
            //抛出异常
            throw new SeckillGoodsOverTimeException("秒杀商品不在时间范围");
        }

        //限制用户购入商品数量——>去订单表找寻答案！！！！！

        // 通过sid查询到秒杀商品表，获取到gid，也就是seckill对象
        Integer gid = seckill.getGid();

    //到达该处，表明已处于秒杀时间范围内

        // 然后根据uid和gid所得到的订单信息，若查询不到直接让用户下单
        //实际上表中的信息不含gid，是直接通过oid 订单表ID 和 uid用户Id
        OrderItem orderItem = orderItemMapper.selectSeckillByUIdAndGid(uid,gid);

        //若表明查询到的OrderItem为NULL，表明该商品为下单过
        if (orderItem == null){
            return;
        }

        //创建时间的转化 时间戳和时间

        //若查询得到订单信息，根据d查询到订单创建时间，与秒杀订单开始与结束，判断是否在这段时间之内，若在其之中则抛出异常，
         Date createTime = orderItem.getCreateTime();

        //将Date对象转化为LocalDateTime
        LocalDateTime time = createTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        //若在订单创建的时间在秒杀时间范围内-抛出异常
        if (seckill.getStartTime().isBefore(time) && seckill.getEndTime().isAfter(time)){
            throw new SeckillGoodsExcessPurchaseQuantityException("用户重复购入");
        }
    }


}
