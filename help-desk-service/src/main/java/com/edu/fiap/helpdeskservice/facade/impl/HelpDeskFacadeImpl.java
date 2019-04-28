package com.edu.fiap.helpdeskservice.facade.impl;

import com.edu.fiap.helpdeskservice.facade.HelpDeskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;
import com.edu.fiap.helpdeskservice.config.KafkaProducerConfig;

@Service
public class HelpDeskFacadeImpl implements HelpDeskFacade {
    @Autowired
    private KafkaTemplate<String, HelpDeskRequest> kafkaTemplate;

    public void createTicket(HelpDeskRequest helpDeskRequest){
        kafkaTemplate.send("createTicket", helpDeskRequest);
    }
}
