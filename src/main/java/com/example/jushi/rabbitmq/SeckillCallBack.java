package com.example.jushi.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 居無何
 * date: 2022/4/23 10:22
 * Description:
 */
@Slf4j
@Component
public class SeckillCallBack implements RabbitTemplate.ConfirmCallback , RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 数据初始化
     * */
    @PostConstruct
    private void init (){

        //注入当前类，为消息返回模式
        rabbitTemplate.setConfirmCallback(this);

        //将该类为返回模式的处理类
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b == true){
            log.info("交换机接收参数成功");
        }else {
            log.error("交换机接收参数失败,失败原因："+s);
        }
    }


    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("队列接收参数失败,失败原因："+returnedMessage.getReplyText());
    }
}
