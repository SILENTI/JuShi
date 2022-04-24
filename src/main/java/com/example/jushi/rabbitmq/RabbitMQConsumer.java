package com.example.jushi.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.example.jushi.service.IOrderService;
import com.example.jushi.service.ISeckillService;
import com.example.jushi.vo.SeckillMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 居無何
 * date: 2022/4/22 16:07
 * Description:
 */
@Service
@Slf4j
public class RabbitMQConsumer {

    @Autowired
    private ISeckillService ISeckillService;

    @Autowired
    private IOrderService IOrderService;

    @RabbitListener(queues = SeckillMQConfig.SECKILL_QUEUE)
    public void seckillConsumer (String message){

        log.info("接收到的消息："+ JSON.parseObject(message,SeckillMessage.class));

        SeckillMessage seckillMessage = JSON.parseObject(message,SeckillMessage.class);

        //消费者在将消息成功消费
        /**
        * 能不能手动确认
        * 也就是如果符合秒杀的条件并下单成功，确认消息已经消费完毕
        * 如果不符合条件？
        * 如果抛出异常，能否将其错误原因返回给前端页面，作为展示！！！
        * 能否通过返回机制，确认该消息，也就是当抛出该异常返回为确认
        * 当该成功后，返回确认,该方法好像不可行
        * */
        try {

            //判断是否还有秒杀资格
            ISeckillService.seckillJudge(seckillMessage.getUid(), seckillMessage.getAid(), seckillMessage.getAid(), seckillMessage.getNum(), seckillMessage.getUserName());

            //直接下单
            IOrderService.creatOrderBySeckill(seckillMessage.getUid(), seckillMessage.getAid(), seckillMessage.getSid(), seckillMessage.getNum(), seckillMessage.getUserName());

        }catch (Exception e){
            /*判断是否订单下单成功，只能通过客户端再次发送请求，判断是否可以*/
            log.error(e.toString());
        }
    }

}
