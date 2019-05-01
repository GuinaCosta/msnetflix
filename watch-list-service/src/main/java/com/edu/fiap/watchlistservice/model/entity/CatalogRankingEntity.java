package com.edu.fiap.watchlistservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * CatalogRankingEntity
 * @author agnaldo.almeida
 */
@Entity(name = "tbRankingAssistidos")
public class CatalogRankingEntity {
    /**
     * ID of the item
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranking_id", nullable = false)
    private Integer rankingId;

    /**
     * ID of the catalog
     **/
    @Column(name = "catalogo_id", nullable = false)
    private Integer catalogId;

    /**
     * catalog Name
     **/
    @Column(name = "catalogo_nome", nullable = false)
    private String catalogName;

    /**
     * catalog category description
     **/
    @Column(name = "categoria", nullable = false)
    private String category;

    /**
     * ID of the catalog
     **/
    @Column(name = "contador", nullable = false)
    private Integer watchCount;

    public Integer getRankingId() {
        return rankingId;
    }

    public void setRankingId(Integer rankingId) {
        this.rankingId = rankingId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }

    /**
     * Cto
     * @param catalogId
     * @param catalogName
     * @param category
     * @param watchCount
     */
    public CatalogRankingEntity(Integer catalogId, String catalogName, String category, Integer watchCount) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.category = category;
        this.watchCount = watchCount;
    }

    /**
     * Cto
     * @param catalogId
     * @param catalogName
     * @param category
     * @param watchCount
     * @param rankingId
     */
    public CatalogRankingEntity(Integer catalogId,
                                String catalogName,
                                String category,
                                Integer watchCount,
                                Integer rankingId) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.category = category;
        this.watchCount = watchCount;
        this.rankingId = rankingId;
    }

    /**
     * Cto
     */
    public CatalogRankingEntity() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogRankingEntity{");
        sb.append("rankingId=").append(rankingId);
        sb.append(", catalogId=").append(catalogId);
        sb.append(", catalogName='").append(catalogName).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", watchCount=").append(watchCount);
        sb.append('}');
        return sb.toString();
    }
}
