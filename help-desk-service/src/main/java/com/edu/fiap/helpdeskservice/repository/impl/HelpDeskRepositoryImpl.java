package com.edu.fiap.helpdeskservice.repository.impl;

import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;
import com.edu.fiap.helpdeskservice.repository.HelpDeskRepository;
import com.edu.fiap.helpdeskservice.repository.RepositoryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @see com.edu.fiap.helpdeskservice.repository.HelpDeskRepository
 **/
@Service
public class HelpDeskRepositoryImpl implements HelpDeskRepository {
    /**
     * kafka template
     **/
    @Autowired
    private KafkaTemplate<String, HelpDeskRequest> kafkaTemplate;

    /**
     * @see HelpDeskRepository#createTicket(HelpDeskRequest)
     **/
    @Override
    public void createTicket(HelpDeskRequest helpDeskRequest) {
        kafkaTemplate.send(RepositoryConstants.HELPDESK_TOPIC_NAME, helpDeskRequest);
    }
}
