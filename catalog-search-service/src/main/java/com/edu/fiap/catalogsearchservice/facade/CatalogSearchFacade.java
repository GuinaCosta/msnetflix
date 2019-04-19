package com.edu.fiap.catalogsearchservice.facade;

/**
 * Inteface para implementação da busca de catálogo
 * */
public interface CatalogSearchFacade {

    /**
     * Bucar catálogo pelo gênero
     *
     * @param genre gênero do filme
     *
     * @return Lista de filmes
     **/
    public Object getCatalogByGenre(String genre);
}
