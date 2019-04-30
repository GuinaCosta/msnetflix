package com.edu.fiap.watchlistservice.repository;

import com.edu.fiap.watchlistservice.model.entity.WatchListItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WatchListRepository extends CrudRepository<WatchListItemEntity, Integer> {

    /**
     * finds the user watchlist
     * @param userId user id
     * @return list of catalogs in user watchlist
     */
    List<WatchListItemEntity> findByUserId(Integer userId);

}
