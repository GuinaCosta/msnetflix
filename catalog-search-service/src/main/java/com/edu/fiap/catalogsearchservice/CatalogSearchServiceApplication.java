package com.edu.fiap.catalogsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Classe de incialização do serviço com Spring
 **/
@SpringBootApplication
@RefreshScope
public class CatalogSearchServiceApplication {

	/**
	 * inicialiazação
	 **/
	public static void main(String[] args) {
		SpringApplication.run(CatalogSearchServiceApplication.class, args);
	}

}
