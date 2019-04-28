package com.edu.fiap.helpdeskservice.facade;

import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;

public interface HelpDeskFacade {

    void createTicket(HelpDeskRequest helpDeskRequest);

    void saveTicket(Object message) throws JsonGenerationException,
            JsonMappingException, IOException, NoSuchFieldException, IllegalAccessException;
}
