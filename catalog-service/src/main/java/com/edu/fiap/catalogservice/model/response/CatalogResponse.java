package com.edu.fiap.catalogservice.model.response;

import com.edu.fiap.catalogservice.model.entity.CatalogEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * Catalog Response Class for endpoints
 *
 * @author agnaldo.almeida
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The catalog id */
    private Integer catalogId;


    /**
     * name of the item
     **/
    private String name;

    /**
     * producer of the item
     **/
    private String producer;

    /**
     * debut date of the item
     **/
    private Date debutDate;

    /**
     * director of the item
     **/
    private String director;

    /**
     * cast of the item
     **/
    private String cast;

    /**
     * category ID of the item
     **/
    private Integer categoryId;

    /**
     * link bio of the item
     **/
    private String link;

    /**
     * time duration of the item
     **/
    private String duration;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Cto of CatalogResponse
     **/
    public CatalogResponse(Integer catalogId) {
        this.catalogId = catalogId;
    }

    /**
     * Cto of CatalogResponse
     **/
    public CatalogResponse() {
    }

    /**
     * Creates an object of CatalogResponse from a CatalogRequest
     * @param catalogEntity a CatalogEntity object
     * @return an object of CatalogResponse
     *
     * @see CatalogRequest
     * */
    @SuppressWarnings("Duplicates")
    public static CatalogResponse createFromCatalogEntity(CatalogEntity catalogEntity) {
        CatalogResponse catalogResponse = new CatalogResponse();

        catalogResponse.setCast(catalogEntity.getCast());
        catalogResponse.setCategoryId(catalogEntity.getCategoryId());
        catalogResponse.setDebutDate(catalogEntity.getDebutDate());
        catalogResponse.setDirector(catalogEntity.getDirector());
        catalogResponse.setDuration(catalogEntity.getDuration());
        catalogResponse.setLink(catalogEntity.getLink());
        catalogResponse.setName(catalogEntity.getName());
        catalogResponse.setCatalogId(catalogEntity.getCatalogId());
        catalogResponse.setProducer(catalogEntity.getProducer());

        return catalogResponse;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogResponse{");
        sb.append("catalogId=").append(catalogId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", debutDate=").append(debutDate);
        sb.append(", director='").append(director).append('\'');
        sb.append(", cast='").append(cast).append('\'');
        sb.append(", categoryId=").append(categoryId);
        sb.append(", link='").append(link).append('\'');
        sb.append(", duration='").append(duration).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
