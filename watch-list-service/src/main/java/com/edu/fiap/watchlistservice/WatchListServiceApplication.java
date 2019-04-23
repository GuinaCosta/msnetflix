package com.edu.fiap.watchlistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class WatchListServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchListServiceApplication.class, args);
	}

}
