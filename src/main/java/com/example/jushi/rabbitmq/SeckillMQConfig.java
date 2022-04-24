package com.example.jushi.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 居無何
 * date: 2022/4/7 10:53
 * Description: 秒杀的RabbitMQ配置类
 */
@Configuration
public class SeckillMQConfig {

    /**交换机名称*/
    public static final String SECKILL_EXCHANGE = "SeckillExchange";

    /**队列名称*/
    public static final String SECKILL_QUEUE = "SeckillQueue";

    /**路由Key: *代替一个字符，#替代一个或者多个字符 */
    public static final String ROUTING_KEY = "jushi.seckill.#";

    /**声明交换机*/
    @Bean(SECKILL_EXCHANGE)
    public TopicExchange SeckillExchange (){
        return ExchangeBuilder.topicExchange(SECKILL_EXCHANGE).durable(true).build();
    }

    /**声明队列*/
    @Bean(SECKILL_QUEUE)
    public Queue SeckillQueue (){
        return QueueBuilder.durable(SECKILL_QUEUE).build();
    }

    /**绑定交换机与队列*/
    @Bean
    public Binding SeckillBinding (@Qualifier(SECKILL_QUEUE) Queue queue , @Qualifier(SECKILL_EXCHANGE) TopicExchange exchange){
        return BindingBuilder.bind(SeckillQueue()).to(SeckillExchange()).with(ROUTING_KEY);
    }
}
