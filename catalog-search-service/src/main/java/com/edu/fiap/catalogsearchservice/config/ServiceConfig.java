package com.edu.fiap.catalogsearchservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Classe para obtenção dos parâmetros de configuração
 */
@Component
public class ServiceConfig {

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String eurekaClientServiceUrl;

    /**
     * Obtêm a URL do Service Discovery
     * @return URL do serviço Eureka
     */
    public String getEurekaServiceUrl(){
        return eurekaClientServiceUrl;
    }
}

