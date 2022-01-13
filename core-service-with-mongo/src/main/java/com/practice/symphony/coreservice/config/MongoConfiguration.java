package com.practice.symphony.coreservice.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
 
@Configuration
@Lazy
public class MongoConfiguration {

	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Lazy
	@Primary
	public MongoTemplate mongoTemplate() {
		TenantContext context = TenantContext.getContext();
		ConnectionString connectionString = new ConnectionString(context.getDbConnectionString());
		return new MongoTemplate(new DatabaseConfiguration(context.getDbConnectionString(),connectionString));
	}

}
 