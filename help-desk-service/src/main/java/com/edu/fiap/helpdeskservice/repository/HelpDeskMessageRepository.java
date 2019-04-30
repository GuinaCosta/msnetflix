package com.edu.fiap.helpdeskservice.repository;

import com.edu.fiap.helpdeskservice.model.entity.HelpDeskEntity;
import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository Interface for managing HelpDesk tickets
 * @author lucas.frigo
 **/
public interface HelpDeskMessageRepository {

    /**
     * Sends topics of HelpDesk to Kafka
     **/
    void createTicket(HelpDeskRequest helpDeskRequest);

    void saveTicket(HelpDeskRequest helpDeskRequest);
}
