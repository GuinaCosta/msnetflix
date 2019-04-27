package com.edu.fiap.catalogservice.facade.impl;

import com.edu.fiap.catalogservice.facade.CatalogServiceFacade;
import com.edu.fiap.catalogservice.model.entity.CatalogEntity;
import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.model.response.CatalogResponse;
import com.edu.fiap.catalogservice.repository.CatalogServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @see com.edu.fiap.catalogservice.facade.CatalogServiceFacade
 **/
@Service
public class CatalogServiceFacadeImpl implements CatalogServiceFacade {

    @Autowired
    private CatalogServiceRepository catalogServiceRepository;

    /**
     * @see CatalogServiceFacade#saveCatalog(CatalogRequest)
     **/
    @Override
    public CatalogResponse saveCatalog(CatalogRequest catalogRequest) {
        CatalogEntity catalogEntity;

        catalogEntity = CatalogEntity.createFromCatalogRequest(catalogRequest);

        Integer id = catalogServiceRepository.save(catalogEntity).getCatalogId();

        //TODO: implementar para postar detalhes no Kafka

        return new CatalogResponse(id);
    }
}
