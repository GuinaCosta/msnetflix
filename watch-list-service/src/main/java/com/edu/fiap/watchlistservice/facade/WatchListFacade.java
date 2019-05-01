package com.edu.fiap.watchlistservice.facade;

import com.edu.fiap.watchlistservice.model.request.WatchListItemRequest;
import com.edu.fiap.watchlistservice.model.response.WatchListItemResponse;

import java.util.List;

/**
 * Watchlist Facade
 */
public interface WatchListFacade {

    /**
     * Get user watch list
     * @param userId user id
     * @return List of WatchListItemResponse
     */
    List<WatchListItemResponse> getUserWatchList(Integer userId);

    /**
     * Adds an item to watch list
     * @param watchListItemRequest watchlist request
     * @return true: for saved item; false: for not saved items
     */
    Boolean addCatalogToWatchList(WatchListItemRequest watchListItemRequest);

    /**
     * Increases watch count of the catalog item
     * @param catalogId catalog id
     * @return total watched times
     */
    Integer updateCatalogRanking(Integer catalogId);

    /**
     * Increases watch count of the catalog item
     * @param catalogId catalog id
     * @return total watched times
     */
    Boolean updateAvaliation(WatchListItemRequest watchListItemRequest);

    /**
     * Mark catalog item as watched
     * @param watchListItemRequest watchlist request
     * @return marked or not marked
     */
    Boolean markAsWatched(WatchListItemRequest watchListItemRequest);

    /**
     * Gets watchlist of watched or not watched catalogs
     * @param watched true: gets watched items; false: gets not watched items
     * @param userId user id
     * @return List of WatchListItemResponse
     */
    List<WatchListItemResponse> getUserWatchedOrNonWatched(Boolean watched, Integer userId);
}
