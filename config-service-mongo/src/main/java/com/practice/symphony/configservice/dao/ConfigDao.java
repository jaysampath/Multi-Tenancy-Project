package com.practice.symphony.configservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.practice.symphony.configservice.entity.Config;

@Repository
public class ConfigDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Config getConfig(int tenantId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("tenantId").is(tenantId))	;
		List<Config> config = mongoTemplate.find(query, Config.class, "tenant_config");
		return config.size()==1 ? config.get(0) : null;
		
	}
	
	public Config updateConfig(Config newConfig) {
		
		Config updatedConfig = mongoTemplate.save(newConfig, "tenant_config");
		return updatedConfig;
	}

}
