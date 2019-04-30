package com.edu.fiap.catalogprocessing.facade;

import com.edu.fiap.catalogprocessing.model.request.CatalogProcessingRequest;

/**
 * Catalog Processing Facade Interface
 * @author agnaldo.almeida
 */
public interface CatalogProcessingFacade {
    /**
     * Manages and saves all catalog details
     * @param catalogRequest catalog data
     * @return true: if catalog details were saved; false: if the details were not saved
     */
    boolean saveCatalogDetails(CatalogProcessingRequest catalogRequest);
}
