package com.edu.fiap.catalogservice.model.entity;

import com.edu.fiap.catalogservice.model.request.CatalogRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Entity class of Catalogs
 *
 * @author agnaldo.almeida
 **/
@Table(name = "tbCatologo")
@Entity(name = "tbCatologo")
public class CatalogEntity {

    /**
     * ID of the item
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_Id", nullable = false)
    private Integer catalogId;

    /**
     * name of the item
     **/
    @Column(name = "nome")
    private String name;

    /**
     * producer of the item
     **/
    @Column(name = "produtor")
    private String producer;

    /**
     * debut date of the item
     **/
    @Column(name = "dataLancamento")
    private Date debutDate;

    /**
     * director of the item
     **/
    @Column(name = "diretor")
    private String director;

    /**
     * cast of the item
     **/
    @Column(name = "elenco")
    private String cast;

    /**
     * category ID of the item
     **/
    @Column(name = "categoria_id")
    private Integer categoryId;

    /**
     * link bio of the item
     **/
    @Column(name = "link")
    private String link;

    /**
     * time duration of the item
     **/
    @Column(name = "Duracao")
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

    @Override
    @SuppressWarnings("Duplicates")
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogEntity{");
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

    /**
     * Creates an object of CatalogEntity from a CatalogRequest
     * @param catalogRequest a CatalogRequest object
     * @return an object of CatalogEntity
     *
     * @see CatalogRequest
     * */
    @SuppressWarnings("Duplicates")
    public static CatalogEntity createFromCatalogRequest(CatalogRequest catalogRequest) {
        CatalogEntity catalogEntity = new CatalogEntity();

        catalogEntity.setCast(catalogRequest.getCast());
        catalogEntity.setCategoryId(catalogRequest.getCategoryId());
        catalogEntity.setDebutDate(catalogRequest.getDebutDate());
        catalogEntity.setDirector(catalogRequest.getDirector());
        catalogEntity.setDuration(catalogRequest.getDuration());
        catalogEntity.setLink(catalogRequest.getLink());
        catalogEntity.setName(catalogRequest.getName());
        catalogEntity.setProducer(catalogRequest.getProducer());

        return catalogEntity;
    }
}