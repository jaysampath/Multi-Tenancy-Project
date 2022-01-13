package com.practice.symphony.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class ConfigServiceMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceMongoApplication.class, args);
	}

}
