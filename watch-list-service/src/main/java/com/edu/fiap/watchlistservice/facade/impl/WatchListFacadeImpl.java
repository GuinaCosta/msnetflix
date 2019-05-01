package com.edu.fiap.watchlistservice.facade.impl;

import com.edu.fiap.watchlistservice.facade.WatchListFacade;
import com.edu.fiap.watchlistservice.model.entity.CatalogEntity;
import com.edu.fiap.watchlistservice.model.entity.CatalogRankingEntity;
import com.edu.fiap.watchlistservice.model.entity.CategoryEntity;
import com.edu.fiap.watchlistservice.model.entity.WatchListItemEntity;
import com.edu.fiap.watchlistservice.model.request.WatchListItemRequest;
import com.edu.fiap.watchlistservice.model.response.WatchListItemResponse;
import com.edu.fiap.watchlistservice.repository.CacheRepository;
import com.edu.fiap.watchlistservice.repository.CatalogRankingEntityRepository;
import com.edu.fiap.watchlistservice.repository.CatalogServiceRepository;
import com.edu.fiap.watchlistservice.repository.CategoryRepository;
import com.edu.fiap.watchlistservice.repository.WatchListRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * @see com.edu.fiap.watchlistservice.facade.WatchListFacade
 */
@Service
public class WatchListFacadeImpl implements WatchListFacade {

    /**
     * WatchListRepository
     */
    @Autowired
    private WatchListRepository watchListRepository;

    /**
     * CatalogRankingEntityRepository
     */
    @Autowired
    private CatalogRankingEntityRepository rankingEntityRepository;

    /**
     * CatalogServiceRepository
     */
    @Autowired
    private CatalogServiceRepository catalogServiceRepository;

    /**
     * CategoryRepository
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Redis repository
     */
    @Autowired
    private CacheRepository<Object> watchlistCacheRepository;

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
     * @see WatchListFacade#updateCatalogRanking(Integer)
     */
    @Override
    public Integer updateCatalogRanking(Integer catalogId) {
        CatalogRankingEntity rankingEntity = rankingEntityRepository.findByCatalogId(catalogId);

        if (null != rankingEntity) {
            Optional<CatalogEntity> catalogEntity = catalogServiceRepository.findById(catalogId);
            if (catalogEntity.isPresent()) {
                rankingEntity = new CatalogRankingEntity();
                rankingEntity.setCatalogId(catalogEntity.get().getCatalogId());
                rankingEntity.setCatalogName(catalogEntity.get().getName());

                Optional<CategoryEntity> categoryEntity =
                        categoryRepository.findById(catalogEntity.get().getCategoryId());
                if (categoryEntity.isPresent()) {
                    rankingEntity.setCategory(categoryEntity.get().getCategoryName());
                }
                else {
                    rankingEntity.setCategory("Desconhecido");
                }
                rankingEntity.setWatchCount(1);
            }
        }
        else {
            rankingEntity.setWatchCount(rankingEntity.getWatchCount() + 1);
        }
        rankingEntityRepository.save(rankingEntity);

        return rankingEntity.getWatchCount();
    }

    /**
     * @see WatchListFacade#getUserWatchedOrNonWatched(Boolean, Integer)
     */
    @Override
    public List<WatchListItemResponse> getUserWatchedOrNonWatched(Boolean watched, Integer userId) {
        String cacheKey = "Watched:".concat(watched.toString()).concat(":").concat(userId.toString());

        Optional<List<WatchListItemEntity>> watchListItems =
                watchListRepository.findByWatchedAndUserId(watched, userId);
        if (watchListItems.isPresent()) {
            this.saveCacheUserWatchedItems(watchListItems.get(), cacheKey);
            return WatchListItemResponse.createListFromEntityList(watchListItems.get());
        }
        else  {
            return WatchListItemResponse.createListFromEntityList(null);
        }
    }

    /**
     * @see WatchListFacade#addCatalogToWatchList(WatchListItemRequest)
     */
    @Override
    public Boolean addCatalogToWatchList(WatchListItemRequest watchListItemRequest) {
        WatchListItemEntity watchListItemEntity = WatchListItemEntity
                .createFromWatchListRequest(watchListItemRequest);
        if (watchListRepository.findByCatalogIdAndUserId(watchListItemRequest.getCatalogId(),
                watchListItemRequest.getUserId()) == null) {
            return watchListRepository.save(watchListItemEntity).getWatchlistListItemId() > 0;
        }
        else {
            return false;
        }
    }

    /**
     * @see WatchListFacade#updateAvaliation(WatchListItemRequest)
     */
    @Override
    public Boolean updateAvaliation(WatchListItemRequest watchListItemRequest) {
        WatchListItemEntity listItemEntity = watchListRepository
                .findByCatalogIdAndUserId(watchListItemRequest.getCatalogId(),
                        watchListItemRequest.getUserId());

        if (listItemEntity != null) {
            listItemEntity.setWatched(true);
            this.updateCatalogRanking(watchListItemRequest.getCatalogId());
            listItemEntity.setAvaliation(watchListItemRequest.getAvaliation());
            return watchListRepository.save(listItemEntity).getWatchlistListItemId() > 0;
        }
        else {
            watchListItemRequest.setWatched(true);
            this.updateCatalogRanking(watchListItemRequest.getCatalogId());
            return this.addCatalogToWatchList(watchListItemRequest);
        }
    }

    /**
     * @see WatchListFacade#markAsWatched(WatchListItemRequest)
     */
    @Override
    public Boolean markAsWatched(WatchListItemRequest watchListItemRequest) {
        return this.updateAvaliation(watchListItemRequest);
    }

    /**
     * saves Cache User WatchList
     * @param watchListItems
     * @param userId
     */
    @SneakyThrows
    private void saveCacheUserWatchList(List<WatchListItemEntity> watchListItems, Integer userId) {
        watchlistCacheRepository.save(userId.toString(), watchListItems, Duration.ofMinutes(1));
    }

    /**
     * saves Cache User Watched Items
     * @param watchListItems
     * @param cacheKey cache key
     */
    @SneakyThrows
    private void saveCacheUserWatchedItems(List<WatchListItemEntity> watchListItems, String cacheKey) {
        watchlistCacheRepository.save(cacheKey, watchListItems, Duration.ofMinutes(1));
    }
}
