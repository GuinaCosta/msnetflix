package com.edu.fiap.catalogsearchservice.facade.impl;

import com.edu.fiap.catalogsearchservice.facade.CatalogSearchFacade;
import com.edu.fiap.catalogsearchservice.repository.CatalogSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe de implementação
 * */
@Service
public class CatalogSearchFacadeImpl implements CatalogSearchFacade {

    @Autowired
    private CatalogSearchRepository catalogSearchRepository;

    @Override
    public Object getCatalogByGenre(String genre) {
        return catalogSearchRepository.getByGenre(genre);
    }
}
