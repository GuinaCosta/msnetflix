package com.edu.fiap.catalogsearchservice.repository.impl;

import com.edu.fiap.catalogsearchservice.model.dto.CatalogDto;
import com.edu.fiap.catalogsearchservice.repository.CatalogSearchRepository;
import org.springframework.stereotype.Component;
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
    public CatalogDto getByGenre(String genre) {
        return new CatalogDto();
    }
}
