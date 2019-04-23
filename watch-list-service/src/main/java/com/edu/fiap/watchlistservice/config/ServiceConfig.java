package com.edu.fiap.watchlistservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

    @Value("${eureka.client.serviceUrl}")
    private String eurekaClientServiceUrl;

    public String getExampleProperty(){
        return eurekaClientServiceUrl;
    }
}

