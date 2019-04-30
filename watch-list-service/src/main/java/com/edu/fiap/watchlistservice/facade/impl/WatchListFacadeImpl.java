package com.edu.fiap.watchlistservice.facade.impl;

import com.edu.fiap.watchlistservice.facade.WatchListFacade;
import com.edu.fiap.watchlistservice.model.entity.WatchListItemEntity;
import com.edu.fiap.watchlistservice.model.response.WatchListItemResponse;
import com.edu.fiap.watchlistservice.repository.CacheRepository;
import com.edu.fiap.watchlistservice.repository.WatchListRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.List;

/**
 * @see com.edu.fiap.watchlistservice.facade.WatchListFacade
 */
public class WatchListFacadeImpl implements WatchListFacade {

    /** The object mapper, convert object to json. */
    @Autowired
    private ObjectMapper mapper;

    /**
     * WatchListRepository
     */
    @Autowired
    private WatchListRepository watchListRepository;

    /**
     * Redis repository
     */
    @Autowired
    private CacheRepository<List<WatchListItemEntity>> watchlistCacheRepository;

    /**
     * @see WatchListFacade#getUserWatchList(Integer)
     */
    @Override
    public List<WatchListItemResponse> getUserWatchList(Integer userId) {

        List<WatchListItemEntity> watchListItems = watchListRepository.findByUserId(userId);
        if (watchListItems != null) {
            this.saveCacheUserWatchList(watchListItems, userId);
        }

        return WatchListItemResponse.createListFromEntityList(watchListItems);
    }

    /**
     * saves Cache User WatchList
     * @param watchListItems
     * @param userId
     */
    @SneakyThrows
    private void saveCacheUserWatchList(List<WatchListItemEntity> watchListItems, Integer userId) {
        watchlistCacheRepository.save(userId.toString(), watchListItems, Duration.ofHours(4));
    }
}
