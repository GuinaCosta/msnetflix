package com.edu.fiap.watchlistservice.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class for request model for endpoints
 *
 * @author agnaldo.almeida
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatchListItemRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

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
     * @param catalogId catalog ID
     * @param userId user id
     * @param avaliation avaliation
     * @param watched indicator if the title is watched
     */
    public WatchListItemRequest(Integer catalogId, Integer userId, Integer avaliation, boolean watched) {
        this.catalogId = catalogId;
        this.userId = userId;
        this.avaliation = avaliation;
        this.watched = watched;
    }

    /**
     * Cto
     */
    public WatchListItemRequest() {
    }
}
