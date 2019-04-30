package com.edu.fiap.catalogprocessing.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity for genre creation
 * @author agnaldo.almeida
 */
@Entity(name = "tbGenero")
public class GenreEntity {

    /**
     * ID of the genre
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_Id", nullable = false)
    private Integer genreId;

    /**
     * genre name
     **/
    @Column(name = "genero")
    private String genre;

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Cto
     */
    public GenreEntity() {
    }

    /**
     * Cto
     * @param genre
     */
    public GenreEntity(String genre) {
        this.genre = genre;
    }

    /**
     * Cto
     * @param genre
     * @param genreId
     */
    public GenreEntity(String genre, Integer genreId) {
        this.genre = genre;
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GenreEntity{");
        sb.append("genreId=").append(genreId);
        sb.append(", genre='").append(genre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
