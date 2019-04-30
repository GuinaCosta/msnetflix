package com.edu.fiap.catalogsearchservice.controller;

import com.edu.fiap.catalogsearchservice.facade.CatalogSearchFacade;
import com.edu.fiap.catalogsearchservice.model.response.CatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller para gerenciar rotas de busca
 *
 * @author agnaldo.almeida
 * */
@RestController
@RequestMapping("catalog/search")
public class CatalogController {

    /**
     * Catalog Search Facade
     **/
    @Autowired
    private CatalogSearchFacade catalogSearchFacade;

    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param genre nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("genre/{genre}")
    public List<CatalogResponse> getByGenre(@PathVariable String genre) {
        return catalogSearchFacade.getCatalogsByGenre(genre);
    }

    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param genre nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("keyword/{keyword}")
    public List<CatalogResponse> getByKeyword(@PathVariable String keyword) {

        return null;
    }

    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param genre nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("mostwatched/categoy/{category}")
    public List<CatalogResponse> getMostWatchedByCategory(@PathVariable String category) {

        return null;
    }

    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param genre nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("mostwatched/genre/{genre}")
    public List<CatalogResponse> getMostWatchedByGenre(@PathVariable String genre) {

        return null;
    }

    @GetMapping("detail/{id}")
    public CatalogResponse getDetail(@PathVariable Integer id) {

        return new CatalogResponse();
    }
}
