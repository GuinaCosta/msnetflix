package com.edu.fiap.helpdeskservice.repository;

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
     * Helpdesk messaging topic name
     **/
    public static final String HELPDESK_TOPIC_NAME = "createTicket";
}
