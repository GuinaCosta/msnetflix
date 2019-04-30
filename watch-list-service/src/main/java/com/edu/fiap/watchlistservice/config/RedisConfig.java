package com.edu.fiap.watchlistservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis Configuration Class
 * @author agnaldo.almeida
 */
@Configuration
@Slf4j
public class RedisConfig {

    /**
     * Jedis Factory
     * @return new Jedis Factory
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        log.trace("Creating Jedis Factory");
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setDefaultSerializer(new StringRedisSerializer());
        template.setConnectionFactory(jedisConnectionFactory());
        template.setEnableTransactionSupport(true);
        return template;
    }
}
