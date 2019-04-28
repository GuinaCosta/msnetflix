package com.edu.fiap.helpdeskservice.repository;

import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;

/**
 * Repository Interface for managing HelpDesk tickets
 * @author lucas.frigo
 **/
public interface HelpDeskRepository {

    /**
     * Sends topics of HelpDesk to Kafka
     **/
    void createTicket(HelpDeskRequest helpDeskRequest);

    void saveTicket(HelpDeskRequest helpDeskRequest);
}
