package com.edu.fiap.helpdeskservice.facade;

import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;

public interface HelpDeskFacade {

    void createTicket(HelpDeskRequest helpDeskRequest);
}
