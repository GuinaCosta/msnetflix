package com.edu.fiap.catalogsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Classe de incialização do serviço com Spring
 **/
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class CatalogSearchServiceApplication {

	/**
	 * inicialiazação
	 **/
	public static void main(String[] args) {
		SpringApplication.run(CatalogSearchServiceApplication.class, args);
	}

}
