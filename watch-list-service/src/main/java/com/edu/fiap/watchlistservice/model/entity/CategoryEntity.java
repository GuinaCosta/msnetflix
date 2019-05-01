package com.edu.fiap.watchlistservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity for category
 * @author agnaldo.almeida
 */
@Entity(name = "tbCategoria")
public class CategoryEntity {

    /**
     * ID of the genre
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id", nullable = false)
    private Integer categoryId;

    /**
     * category name
     **/
    @Column(name = "nome")
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Cto
     * @param categoryName
     */
    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Cto
     * @param categoryName
     * @param categoryId
     */
    public CategoryEntity(String categoryName, Integer categoryId) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    /**
     * Cto
     */
    public CategoryEntity() {
    }
}
