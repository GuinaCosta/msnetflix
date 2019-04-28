package com.edu.fiap.catalogprocessing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@Slf4j
public class CatalogProcessingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("Iniciando aplicação...");
		SpringApplication.run(CatalogProcessingApplication.class, args);
		log.info("Aplicação inicializada...");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Executando: command line runner - {}", args);
	}
}

