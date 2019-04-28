package com.edu.fiap.catalogservice.repository;

import com.edu.fiap.catalogservice.model.request.CatalogRequest;

/**
 * Interface for managing messaging of Catalog item
 * @author agnaldo.almeida
 */
public interface CatalogMessageRepository {

    /**
     * Sends Catalog data to the messaging service
     * @param catalogRequest catalog item data for message
     * @return true: if the messagem was posted; false: if the message was not posted
     */
    boolean createCatalogMessage(CatalogRequest catalogRequest);
}
