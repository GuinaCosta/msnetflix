package com.edu.fiap.catalogprocessing.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity for catalog genre creation
 * @author agnaldo.almeida
 */
@Entity(name = "tbGeneroCatalogo")
public class CatalogGenreEntity {

    /**
     * ID of the catalog genre
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GeneroCatalogo_Id", nullable = false)
    private Integer catalogGenreId;

    /**
     * genre name
     **/
    @Column(name = "genero")
    private String genre;

    /**
     * ID of the catalog
     **/
    @Column(name = "catalog_Id")
    private Integer catalogId;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getCatalogGenreId() {
        return catalogGenreId;
    }

    public void setCatalogGenreId(Integer catalogGenreId) {
        this.catalogGenreId = catalogGenreId;
    }

    /**
     * Cto
     */
    public CatalogGenreEntity() {
    }

    /**
     * Cto
     * @param genre
     * @param catalogId
     */
    public CatalogGenreEntity(String genre, Integer catalogId) {
        this.genre = genre;
        this.catalogId = catalogId;
    }

    /**
     * Cto
     * @param genre
     * @param catalogId
     * @param catalogGenreId
     */
    public CatalogGenreEntity(String genre, Integer catalogId, Integer catalogGenreId) {
        this.genre = genre;
        this.catalogId = catalogId;
        this.catalogGenreId = catalogGenreId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogGenreEntity{");
        sb.append("genre='").append(genre).append('\'');
        sb.append(", catalogId=").append(catalogId);
        sb.append('}');
        return sb.toString();
    }
}
