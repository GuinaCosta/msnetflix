package com.edu.fiap.catalogsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class CatalogSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogSearchServiceApplication.class, args);
	}

}
