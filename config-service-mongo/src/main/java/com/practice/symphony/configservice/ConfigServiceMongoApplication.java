package com.practice.symphony.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigServiceMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceMongoApplication.class, args);
	}

}
