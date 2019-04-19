package com.edu.fiap.catalogsearchservice.model.request;

/**
 * Modelo de request
 *
 * @author agnaldo.almeida
 **/
public class CatalogRequest {

    /**
     * nome do item do catálogo
     **/
    private String name;

    /**
     * nome do item do catálogo
     **/
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
