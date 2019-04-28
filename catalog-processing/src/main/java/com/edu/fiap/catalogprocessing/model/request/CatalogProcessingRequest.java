package com.edu.fiap.catalogprocessing.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class for request model of kafka messages
 *
 * @author agnaldo.almeida
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogProcessingRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * ID of the item
     **/
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

    /**
     * key words of the item
     **/
    private List<String> keyWords;

    /**
     * genres of the item
     **/
    private List<String> genres;

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

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogProcessingRequest{");
        sb.append("catalogId=").append(catalogId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", debutDate=").append(debutDate);
        sb.append(", director='").append(director).append('\'');
        sb.append(", cast='").append(cast).append('\'');
        sb.append(", categoryId=").append(categoryId);
        sb.append(", link='").append(link).append('\'');
        sb.append(", duration='").append(duration).append('\'');
        sb.append(", keyWords=").append(keyWords);
        sb.append(", genres=").append(genres);
        sb.append('}');
        return sb.toString();
    }
}
