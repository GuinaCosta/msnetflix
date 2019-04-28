package com.edu.fiap.catalogservice.facade;

import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.model.response.CatalogResponse;

import java.util.List;

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

    /**
     * Finds the catalogs details by name
     * @param name catalog name to find
     * @return list of CatalogResponse found
     **/
    List<CatalogResponse> getCatalogs(String name);

    /**
     * Finds the catalog by its ID
     * @param id id of the catalog item
     * @return CatalogResponse item found
     **/
    CatalogResponse getCatalog(Integer id);
}
