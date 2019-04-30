package com.edu.fiap.catalogprocessing.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity for catalog keywords creation
 * @author agnaldo.almeida
 */
@Entity(name = "tbPalavrasChaveCatalogo")
public class CatalogKeywordsEntity {

    /**
     * ID of the catalog keyword
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer catalogKeywordId;

    /**
     * keyword
     **/
    @Column(name = "palavra_chave")
    private String keyword;

    /**
     * ID of the catalog
     **/
    @Column(name = "catalog_Id")
    private Integer catalogId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getCatalogKeywordId() {
        return catalogKeywordId;
    }

    public void setCatalogKeywordId(Integer catalogKeywordId) {
        this.catalogKeywordId = catalogKeywordId;
    }

    /**
     * Cto
     * @param keyword
     * @param catalogId
     */
    public CatalogKeywordsEntity(String keyword, Integer catalogId) {
        this.keyword = keyword;
        this.catalogId = catalogId;
    }

    /**
     * Cto
     * @param keyword
     * @param catalogId
     */
    public CatalogKeywordsEntity(String keyword, Integer catalogId, Integer catalogKeywordId) {
        this.keyword = keyword;
        this.catalogId = catalogId;
        this.catalogKeywordId = catalogKeywordId;
    }

    /**
     * Cto
     */
    public CatalogKeywordsEntity() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogKeywordsEntity{");
        sb.append("keyword='").append(keyword).append('\'');
        sb.append(", catalogId=").append(catalogId);
        sb.append('}');
        return sb.toString();
    }
}
