package com.edu.fiap.catalogsearchservice.facade.impl;

import com.edu.fiap.catalogsearchservice.facade.CatalogSearchFacade;
import com.edu.fiap.catalogsearchservice.model.dto.CatalogDto;
import com.edu.fiap.catalogsearchservice.model.response.CatalogResponse;
import com.edu.fiap.catalogsearchservice.repository.CatalogSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de implementação da busca de catálogos
 *
 * @author agnaldo.almeida
 * */
@Service
public class CatalogSearchFacadeImpl implements CatalogSearchFacade {

    /**
     * Repositório para busca de catálogos
     **/
    @Autowired
    private CatalogSearchRepository catalogSearchRepository;

    /**
     * @see CatalogSearchFacade#getCatalogsByGenre(String)
     * */
    @Override
    public List<CatalogResponse> getCatalogsByGenre(String genre) {
        CatalogDto catalogDto = catalogSearchRepository.getByGenre(genre);
        List<CatalogResponse> lista = new ArrayList<>();
        lista.add(new CatalogResponse(catalogDto.getName(), 0));

        return lista;
    }
}
