package com.le.leseckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.cdi.RedisRepositoryBean;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.RedisCollectionFactoryBean;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //value的序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //hash的key的序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //hash的value的序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        //注入连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
