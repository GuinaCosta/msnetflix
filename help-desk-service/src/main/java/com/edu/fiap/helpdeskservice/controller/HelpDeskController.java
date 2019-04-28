package com.edu.fiap.helpdeskservice.controller;

import com.edu.fiap.helpdeskservice.facade.HelpDeskFacade;
import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helpdesk")
public class HelpDeskController {

    @Autowired
    private HelpDeskFacade helpDeskFacade;

    @PostMapping()
    public void createTicket(@NotNull @RequestBody HelpDeskRequest helpDeskRequest){
        helpDeskFacade.createTicket(helpDeskRequest);
    }

}
