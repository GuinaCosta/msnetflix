package com.edu.fiap.catalogsearchservice.repository.impl;

import com.edu.fiap.catalogsearchservice.model.entity.CatalogEntity;
import com.edu.fiap.catalogsearchservice.repository.CatalogSearchRepository;
import org.springframework.stereotype.Service;

/**
 * Classe de implementação da busca de catálogos
 *
 * @author agnaldo.almeida
 * */
@Service
public class CatalogSearchRepositoryImpl implements CatalogSearchRepository {

    /**
     * @see CatalogSearchRepository#getByGenre(String)
     **/
    @Override
    public CatalogEntity getByGenre(String genre) {
        return new CatalogEntity();
    }
}
