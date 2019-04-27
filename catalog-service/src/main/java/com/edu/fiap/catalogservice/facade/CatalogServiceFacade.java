package com.edu.fiap.catalogservice.facade;

import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.model.response.CatalogResponse;

/**
 * Catalog orchestration facade
 * */
public interface CatalogServiceFacade {

    /**
     * Process catalog item to save on database and post catalog details
     * to be processed
     * @param catalogRequest catalog details to be inserted
     * @return a catalog response item
     * */
    CatalogResponse saveCatalog(CatalogRequest catalogRequest);
}
