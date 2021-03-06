package com.edu.fiap.catalogsearchservice.model.response;


import java.io.Serializable;

/**
 * Modelo de resposta de catálogo
 *
 * @author agnaldo.almeida
 **/
public class CatalogResponse implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public CatalogResponse(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public CatalogResponse() {
    }
}
