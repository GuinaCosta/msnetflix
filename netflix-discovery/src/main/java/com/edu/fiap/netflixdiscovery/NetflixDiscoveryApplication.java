package com.edu.fiap.netflixdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetflixDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixDiscoveryApplication.class, args);
	}

}
