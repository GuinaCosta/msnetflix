package com.edu.fiap.watchlistservice.model.entity;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Entity class of Catalogs
 *
 * @author agnaldo.almeida
 **/
@Entity(name = "tbCatalogoUsuario")
@RedisHash("CatalogoUsuario")
public class WatchListItemEntity implements Serializable {

    /**
     * ID of the item
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatalogoUsuario_Id", nullable = false)
    private Integer watchlistListItemId;

    /**
     * catalog_Id
     **/
    @Column(name = "catalog_Id")
    private Integer catalogId;

    /**
     * usuario id
     **/
    @Column(name = "usuario_id")
    private Integer userId;

    /**
     * debut date of the item
     **/
    @Column(name = "notaAvalida")
    private Integer avaliation;

    /**
     * director of the item
     **/
    @Column(name = "AssitiuCompleto")
    private boolean watched;

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
     * @param catalogId
     * @param userId
     * @param avaliation
     * @param watched
     */
    public WatchListItemEntity(Integer catalogId, Integer userId, Integer avaliation, boolean watched) {
        this.catalogId = catalogId;
        this.userId = userId;
        this.avaliation = avaliation;
        this.watched = watched;
    }

    /**
     * Cto
     */
    public WatchListItemEntity() {
    }
}