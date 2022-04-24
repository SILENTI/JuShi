package com.example.jushi.controller;

import com.alibaba.fastjson.JSON;
import com.example.jushi.model.Order;
import com.example.jushi.model.User;
import com.example.jushi.service.IOrderService;
import com.example.jushi.service.ISeckillService;
import com.example.jushi.service.ex.SeckillGoodsExcessPurchaseQuantityException;
import com.example.jushi.service.ex.SeckillGoodsIsNull;
import com.example.jushi.service.ex.SeckillGoodsSellOutException;
import com.example.jushi.service.ex.UserLoginInfoExpiredException;
import com.example.jushi.util.JsonResult;
import com.example.jushi.rabbitmq.RabbitMQSender;
import com.example.jushi.vo.SeckillGoodsVo;
import com.example.jushi.vo.SeckillMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 居無何
 * @since 2022/03/19
 */
@Slf4j
@RestController
@RequestMapping("/jushi/seckill")
public class SeckillController implements InitializingBean {

    @Autowired
    private ISeckillService ISeckillService;

    @Autowired
    private IOrderService IOrderService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    /**
     * 秒杀商品的展示
     * @return
     */
    @RequestMapping("/show_seckill")
    public JsonResult<List<SeckillGoodsVo>> showSeckillGoods (){


        //使用Redis缓存页面

        List<SeckillGoodsVo> seckillGoodsVos = null;

        //在Redis中获取数据
        seckillGoodsVos = (List<SeckillGoodsVo>) redisTemplate.opsForValue().get("seckillGoodsVos");

        if (seckillGoodsVos == null){

            seckillGoodsVos = ISeckillService.showSeckill();

            //缓存到Redis
            redisTemplate.opsForValue().set("seckillGoodsVos",seckillGoodsVos,60, TimeUnit.SECONDS);

        }

        return new JsonResult<>(seckillGoodsVos,"数据获取成功");
    }

    /**
     * 秒杀商品订单
     * @param aid
     * @param sid
     * @param num
     * @param session
     * @return
     */
    @RequestMapping("/create_seckill_order")
    public JsonResult<Order> createOrderBySeckill (Integer aid, Integer sid, Integer num, HttpSession session){

        //获取user对象
        User user = (User) session.getAttribute("user");

        //获取库存值
        ValueOperations valueOperations = redisTemplate.opsForValue();

        //先判断库存知否满足需求
        if (valueOperations == null){
            //缓存中存储的信息为null，抛出异常
            throw new SeckillGoodsIsNull("Redis中的消息未null");
        }

        //库存数量
        Integer count = (Integer) valueOperations.get("seckillSid:"+sid);

        if ( sid > count ){
            //若其库存中的数量不足，抛出异常商品销售殆尽
             throw new SeckillGoodsSellOutException("商品销售殆尽");
        }
         if ((count-num) < 0){
             throw new SeckillGoodsExcessPurchaseQuantityException("下单的数量不合理");
         }
        //判断是否当前商品的秒杀条件-检验秒杀条件是否符合->对于该步可以简化

        //商品预减
        valueOperations.set("seckillSid:"+sid,count-num);

        //加入RabbitMQ-向其传奇User和aid、sid、num，交由消费者处理。可以将其封装成一个对象。
        SeckillMessage message = new SeckillMessage(user.getUid(),sid,aid,num,user.getUsername());

        //通过Send发送消息->通过工具类将message转化为String类型，并进行排队
        rabbitMQSender.sendSeckillMessage(JSON.toJSONString(message));

        //进行商品下单， 应该是在消费者中，进行下单
        /*Order order = IOrderService.creatOrderBySeckill(user.getUid(), aid, sid, num, user.getUsername());*/

        return new JsonResult<>("下单排队中");
    }

    /**
     * 商品库存的预加载
     * 实现InitializingBean，重写afterPropertiesSet方法，也就是初始化方法，在初始化该类时，会调用该重写方法
     * */
    @Override
    public void afterPropertiesSet() throws Exception {

        //获取库存信息并判断库存，存储到redis中
         List<SeckillGoodsVo> goodsVos = ISeckillService.showSeckill();

         //若获取的库存为null
         if (goodsVos.isEmpty()){
             log.error("未能查询到秒杀商品");
             return;
         }

        for (SeckillGoodsVo goodsVo : goodsVos) {
            //log.info("goodsVo的数据："+goodsVo.toString());
            //以秒杀商品的id和库存存入Redis中
            redisTemplate.opsForValue().set("seckillSid:"+goodsVo.getSid(),goodsVo.getCount());
        }
    }

    /**
     * 通过user和sid判断用户是否下单成功
     * @param user
     * @param sid
     * @return
     */
    @RequestMapping("/seckill_order")
    public JsonResult<String> judgeSeckillOrder (User user , Integer sid){

        JsonResult jsonResult = new JsonResult<>("下单成功");

        //进行判断操作
        boolean judge =  IOrderService.judgeSeckillOrder(user, sid);

        if (judge==false){
            jsonResult.setDescription("下单失败");
        }

        return jsonResult;
    }
}
