package com.edu.fiap.watchlistservice.controller;

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
    public static final String SERVICE_URL_PREFIX = "watchlist";

    /**
     * service url avaliation
     **/
    public static final String SERVICE_URL_AVALIATION = "avaliation";

    /**
     * service url watched
     **/
    public static final String SERVICE_URL_WATCHED = "watched";

}
