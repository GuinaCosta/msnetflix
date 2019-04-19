package com.edu.fiap.catalogsearchservice.facade;

import com.edu.fiap.catalogsearchservice.model.response.CatalogResponse;

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
    public CatalogResponse getCatalogByGenre(String genre);
}
