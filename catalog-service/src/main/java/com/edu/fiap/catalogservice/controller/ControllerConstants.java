package com.edu.fiap.catalogservice.controller;

/**
 * Constants of the controller
 **/
public class ControllerConstants {

    /**
     * Illegal Construction
     **/
    private ControllerConstants() {
        throw new IllegalStateException();
    }

    /**
     * Catalog service url prefix
     **/
    public static final String SERVICE_URL_PREFIX = "catalog";

    /**
     * Catalog service url by name
     **/
    public static final String SERVICE_URL_BY_NAME = "byname";

}
