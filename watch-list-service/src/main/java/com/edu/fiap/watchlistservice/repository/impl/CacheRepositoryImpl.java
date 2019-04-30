package com.edu.fiap.watchlistservice.repository.impl;

import com.edu.fiap.watchlistservice.model.entity.WatchListItemEntity;
import com.edu.fiap.watchlistservice.repository.CacheRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.util.Optional;

/**
 * @see com.edu.fiap.watchlistservice.repository.CacheRepository
 */
public class CacheRepositoryImpl<T> implements CacheRepository<T> {

    /** The object mapper, convert object to json. */
    @Autowired
    private ObjectMapper mapper;

    /** The redis template. */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * @see CacheRepository#delete(String)
     */
    @Override
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * @see CacheRepository#find(String, Class)
     */
    @Override
    @SneakyThrows
    public Optional<T> find(String key, Class<T> value) {
        String str = redisTemplate.opsForValue().get(key);

        if(!ObjectUtils.isEmpty(str)) {
            return Optional.of(mapper.readValue(str, value));
        }

        return Optional.empty();
    }

    /**
     * @see CacheRepository#save(String, Object, Duration)
     */
    @Override
    @SneakyThrows
    public void save(String key, T value, Duration duration) {
        redisTemplate.opsForValue().set(key, mapper.writeValueAsString(value), duration);
    }
}
