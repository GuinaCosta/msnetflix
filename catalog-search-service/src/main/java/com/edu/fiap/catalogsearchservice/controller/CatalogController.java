package com.edu.fiap.catalogsearchservice.controller;

import com.edu.fiap.catalogsearchservice.facade.CatalogSearchFacade;
import com.edu.fiap.catalogsearchservice.model.response.CatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para gerenciar rotas de busca
 *
 * @author agnaldo.almeida
 * */
@RestController("catalog/search")
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
    public CatalogResponse getByGenre(@PathVariable(name="genre") String genre) {

       return catalogSearchFacade.getCatalogByGenre(genre);
    }
}
