package com.edu.fiap.helpdeskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class HelpDeskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskServiceApplication.class, args);
	}

}
