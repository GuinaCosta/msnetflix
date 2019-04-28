package com.edu.fiap.helpdeskservice.facade.impl;

import com.edu.fiap.helpdeskservice.facade.HelpDeskFacade;
import com.edu.fiap.helpdeskservice.repository.HelpDeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;

/**
 * @see com.edu.fiap.helpdeskservice.facade.HelpDeskFacade
 **/
@Service
public class HelpDeskFacadeImpl implements HelpDeskFacade {

    /**
     * Repository instance to access kafka
     **/
    @Autowired
    private HelpDeskRepository helpDeskRepository;

    /**
     * @see HelpDeskFacade#createTicket(HelpDeskRequest)
     **/
    public void createTicket(HelpDeskRequest helpDeskRequest){
        helpDeskRepository.createTicket(helpDeskRequest);
    }
}
