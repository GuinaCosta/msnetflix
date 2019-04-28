package com.edu.fiap.catalogservice.repository;

/**
 * Repository constants
 *
 * @author agnaldo.almeida
 */
public class RepositoryConstants {

    /**
     * Illegal Constructor
     **/
    private RepositoryConstants() {
        throw new IllegalStateException();
    }

    /**
     * Catalog messaging topic name
     **/
    public static final String CATALOG_TOPIC_NAME = "catalogCreation";
}
