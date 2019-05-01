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
    List<CatalogResponse> getCatalogsByGenre(String genre);

    /**
     * Buscar catálago pelos mais vistos de um gênero
     * @param genre gênero do filme
     * @return lista de filmes
     */
    List<CatalogResponse> getMostWatchedByGenre(String genre);

    /**
     * Buscar catálogo pelos mais vistos de uma categoria
     * @param category categoria do filme
     * @return lista de filmes
     */
    List<CatalogResponse> getMostWatchedByCategory(String category);

    /**
     * Buscar filmes por palavra chave
     * @param keyword palavra chave
     * @return lista de filmes
     */
    List<CatalogResponse> getByKeyword(String keyword);
}
