package com.edu.fiap.helpdeskservice.repository.impl;

import com.edu.fiap.helpdeskservice.model.entity.HelpDeskEntity;
import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;
import com.edu.fiap.helpdeskservice.repository.HelpDeskMessageRepository;
import com.edu.fiap.helpdeskservice.repository.HelpDeskRepository;
import com.edu.fiap.helpdeskservice.repository.RepositoryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @see HelpDeskMessageRepository
 **/
@Service
public class HelpDeskMessageRepositoryImpl implements HelpDeskMessageRepository {
    /**
     * kafka template
     **/
    @Autowired
    private KafkaTemplate<String, HelpDeskRequest> kafkaTemplate;

    @Autowired
    private HelpDeskRepository helpDeskRepository;

    /**
     * @see HelpDeskMessageRepository#createTicket(HelpDeskRequest)
     **/
    @Override
    public void createTicket(HelpDeskRequest helpDeskRequest) {
        kafkaTemplate.send(RepositoryConstants.HELPDESK_TOPIC_NAME, helpDeskRequest);
    }

    @Override
    public void saveTicket(HelpDeskRequest helpDeskRequest){
        HelpDeskEntity helpDeskEntity = HelpDeskEntity.createFromHelpDeskRequest(helpDeskRequest);
        helpDeskRepository.save(helpDeskEntity);
    }



}
