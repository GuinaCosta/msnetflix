package com.edu.fiap.helpdeskservice.facade.impl;

import com.edu.fiap.helpdeskservice.facade.HelpDeskFacade;
import com.edu.fiap.helpdeskservice.repository.HelpDeskMessageRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;

import java.io.IOException;
import java.lang.reflect.Field;


/**
 * @see com.edu.fiap.helpdeskservice.facade.HelpDeskFacade
 **/
@Service
public class HelpDeskFacadeImpl implements HelpDeskFacade {

    /**
     * Repository instance to access kafka
     **/
    @Autowired
    private HelpDeskMessageRepository helpDeskRepository;

    /**
     * @see HelpDeskFacade#createTicket(HelpDeskRequest)
     **/
    public void createTicket(HelpDeskRequest helpDeskRequest){
        helpDeskRepository.createTicket(helpDeskRequest);
    }

    @KafkaListener(topics = "createTicket")
    public void saveTicket(@Payload Object message) throws JsonGenerationException,
            JsonMappingException, IOException, NoSuchFieldException, IllegalAccessException {

        Field valueField = message.getClass().getDeclaredField("value");
        valueField.setAccessible(true);
        String messageValue = valueField.get(message).toString();
        ObjectMapper mapper = new ObjectMapper();
        HelpDeskRequest req = mapper.readValue(messageValue, HelpDeskRequest.class);
        helpDeskRepository.saveTicket(req);
    }
}
