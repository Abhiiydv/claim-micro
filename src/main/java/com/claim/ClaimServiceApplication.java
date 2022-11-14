package com.claim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClaimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimServiceApplication.class, args);
	}

}
