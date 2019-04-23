package com.edu.fiap.helpdeskservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String eurekaClientServiceUrl;

    public String getExampleProperty(){
        return eurekaClientServiceUrl;
    }
}

