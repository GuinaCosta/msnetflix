package com.edu.fiap.catalogsearchservice.facade;

import com.edu.fiap.catalogsearchservice.model.response.CatalogResponse;

import java.util.List;

/**
 * Inteface para implementação da busca de catálogo
 *
 * @author agnaldo.almeida
 * */
public interface CatalogSearchFacade {

    /**
     * Bucar catálogo pelo gênero
     *
     * @param genre gênero do filme
     *
     * @return Lista de filmes
     **/
    public List<CatalogResponse> getCatalogsByGenre(String genre);
}
