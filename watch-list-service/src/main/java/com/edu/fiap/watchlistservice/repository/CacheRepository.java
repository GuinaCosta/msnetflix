package com.edu.fiap.watchlistservice.repository;

import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

/**
 * Cache repository
 * @param <T> Object Type
 */
public interface CacheRepository<T>{
    /**
     * Deletes an object in the cache from the input key.
     *
     * @param key the key
     * @return true, if successful
     */
    boolean delete(String key);

    /**
     * Find an object in the cache from the input key.
     *
     * @param key the key
     * @param value the value
     * @return the optional
     */
    Optional<T> find(String key, Class<T> value);



    /**
     * Save an object in the cache with duration.
     *
     *
     * @param key the key
     * @param value the value
     * @param duration the duration
     */
    void save(String key, T value, Duration duration);
}
