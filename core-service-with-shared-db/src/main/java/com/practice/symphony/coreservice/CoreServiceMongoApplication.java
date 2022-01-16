package com.practice.symphony.coreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CoreServiceMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreServiceMongoApplication.class, args);
	}

}
