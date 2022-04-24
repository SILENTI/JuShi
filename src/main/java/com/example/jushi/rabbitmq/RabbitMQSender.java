package com.example.jushi.rabbitmq;

import com.example.jushi.rabbitmq.SeckillMQConfig;
import com.example.jushi.vo.SeckillMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 居無何
 * date: 2022/4/22 15:28
 * Description: 消息的发送者
 */
@Component
@Slf4j
public class  RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String routingKey = "jushi.seckill.sendMessage";

    public void sendSeckillMessage (SeckillMessage message){
        log.info("发送的消息体："+message.toString());
        rabbitTemplate.convertAndSend(SeckillMQConfig.SECKILL_EXCHANGE,routingKey,message);
    }

    public void sendSeckillMessage (String message){
        log.info("发送的消息体："+message.toString());
        rabbitTemplate.convertAndSend(SeckillMQConfig.SECKILL_EXCHANGE,routingKey,message);
    }

}
