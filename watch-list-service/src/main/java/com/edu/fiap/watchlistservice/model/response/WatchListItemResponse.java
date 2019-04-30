package com.edu.fiap.watchlistservice.model.response;

import com.edu.fiap.watchlistservice.model.entity.WatchListItemEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for response model for endpoints
 *
 * @author agnaldo.almeida
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatchListItemResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * ID of the item
     **/
    private Integer watchlistListItemId;

    /**
     * catalog_Id
     **/
    private Integer catalogId;

    /**
     * usuario id
     **/
    private Integer userId;

    /**
     * debut date of the item
     **/
    private Integer avaliation;

    /**
     * director of the item
     **/
    private boolean watched;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getWatchlistListItemId() {
        return watchlistListItemId;
    }

    public void setWatchlistListItemId(Integer watchlistListItemId) {
        this.watchlistListItemId = watchlistListItemId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAvaliation() {
        return avaliation;
    }

    public void setAvaliation(Integer avaliation) {
        this.avaliation = avaliation;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    /**
     * Cto
     * @param watchlistListItemId
     * @param catalogId
     * @param userId
     * @param avaliation
     * @param watched
     */
    public WatchListItemResponse(Integer watchlistListItemId, Integer catalogId, Integer userId, Integer avaliation, boolean watched) {
        this.watchlistListItemId = watchlistListItemId;
        this.catalogId = catalogId;
        this.userId = userId;
        this.avaliation = avaliation;
        this.watched = watched;
    }

    /**
     * Cto
     */
    public WatchListItemResponse() {
    }

    /**
     * Creates a list of response from entity list
     * @param entityList entity list
     * @return List<WatchListItemResponse>
     */
    public static List<WatchListItemResponse> createListFromEntityList(List<WatchListItemEntity> entityList) {
        List<WatchListItemResponse> watchListItemResponseList = new ArrayList<>();

        if (entityList != null && entityList.size() > 0) {
            watchListItemResponseList.addAll(entityList
                    .stream()
                    .map(watchListItemEntity ->
                            new WatchListItemResponse(watchListItemEntity.getWatchlistListItemId(),
                                    watchListItemEntity.getCatalogId(),
                                    watchListItemEntity.getUserId(),
                                    watchListItemEntity.getAvaliation(),
                                    watchListItemEntity.isWatched()))
                    .collect(Collectors.toList()));
        }

        return watchListItemResponseList;
    }
}
