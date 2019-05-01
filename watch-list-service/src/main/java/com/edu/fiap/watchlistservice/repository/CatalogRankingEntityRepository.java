package com.edu.fiap.watchlistservice.repository;

import com.edu.fiap.watchlistservice.model.entity.CatalogRankingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CatalogRankingEntityRepository
 */
@Repository
public interface CatalogRankingEntityRepository extends CrudRepository<CatalogRankingEntity, Integer> {

    /**
     * finds the ranking by catalog id
     * @param catalogId catalog Id
     * @return list of catalogs in user watchlist
     */
    CatalogRankingEntity findByCatalogId(Integer catalogId);

    /**
     * Finds all ranking ordered by watch count
     * @return
     */
    List<CatalogRankingEntity> findAllByOrderByWatchCount();
}
