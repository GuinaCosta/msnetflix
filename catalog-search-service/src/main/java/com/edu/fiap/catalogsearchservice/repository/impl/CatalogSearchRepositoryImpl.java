package com.edu.fiap.catalogsearchservice.repository.impl;

import com.edu.fiap.catalogsearchservice.repository.CatalogSearchRepository;
import org.springframework.stereotype.Component;

/**
 * Classe de implementação da busca de catálogos
 * */
@Component
public class CatalogSearchRepositoryImpl implements CatalogSearchRepository {

    @Override
    public Object getByGenre(String genre) {
        return null;
    }
}
