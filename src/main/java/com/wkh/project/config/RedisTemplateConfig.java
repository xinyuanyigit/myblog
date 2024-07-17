package com.wkh.project.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;


/**
 * Redis的配置类
 * 用于配置 RedisTemplate，以便在 Spring 应用中使用 Redis
 * @author wangkehua
 */
@Configuration
public class RedisTemplateConfig {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    /**
     * 配置 RedisTemplate 实例
     *
     * @return 配置好的 RedisTemplate 实例
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置 Redis 连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 使用GenericJackson2JsonRedisSerializer作为值的序列化器
        redisTemplate.setValueSerializer(new
                GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new
                GenericJackson2JsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
