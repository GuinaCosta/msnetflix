package com.edu.fiap.catalogprocessing.config;

/**
 * Repository constants
 *
 * @author agnaldo.almeida
 */
public class GlobalConstants {

    /**
     * Illegal Constructor
     **/
    private GlobalConstants() {
        throw new IllegalStateException();
    }

    /**
     * Catalog messaging topic name
     **/
    public static final String CATALOG_TOPIC_NAME = "catalogCreation";
}
