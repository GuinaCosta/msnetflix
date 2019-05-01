package com.edu.fiap.watchlistservice.repository;

import com.edu.fiap.watchlistservice.model.entity.WatchListItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchListRepository extends CrudRepository<WatchListItemEntity, Integer> {

    /**
     * finds the user watchlist
     * @param userId user id
     * @return list of catalogs in user watchlist
     */
    List<WatchListItemEntity> findByUserId(Integer userId);

    /**
     * finds the user watchlist
     * @param catalogId catalog id
     * @param userId user id
     * @return list of catalogs in user watchlist
     */
    WatchListItemEntity findByCatalogIdAndUserId(Integer catalogId, Integer userId);

    /**
     * finds the user watchlist
     * @param userId user id
     * @return list of catalogs in user watchlist
     */
    Optional<List<WatchListItemEntity>> findByWatchedAndUserId(Boolean watched, Integer userId);
}
