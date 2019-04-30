package com.edu.fiap.watchlistservice.facade;

import com.edu.fiap.watchlistservice.model.response.WatchListItemResponse;

import java.util.List;

/**
 * Watchlist Facade
 */
public interface WatchListFacade {

    List<WatchListItemResponse> getUserWatchList(Integer userId);
}
