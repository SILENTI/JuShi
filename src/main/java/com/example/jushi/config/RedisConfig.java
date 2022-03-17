package com.example.jushi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author 居無何
 * date: 2022/3/17 14:16
 * Description:
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        //创建redisTemplate对象
        RedisTemplate <String,Object> redisTemplate = new RedisTemplate<>();

        //将对象序列化

        //将Key值序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //将value序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //Hash类型，key值序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        //Hash类型 value序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        //工厂出件
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        return redisTemplate;
    }

}
