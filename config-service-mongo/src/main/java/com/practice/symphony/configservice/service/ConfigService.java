package com.practice.symphony.configservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.symphony.configservice.dao.ConfigDao;
import com.practice.symphony.configservice.entity.Config;

@Service
public class ConfigService {
	
	@Autowired
	private ConfigDao configDao;
	
	Logger logger = LoggerFactory.getLogger(ConfigService.class);
	
	private CacheService cacheService;
	
	public Config getConfig(int tenantId) {
		//Object configFromCache = cacheService.getConfig(tenantId);
		
//		if(configFromCache!=null) {
//			return (Config) configFromCache;
//		}
		
		logger.info("Expired in cache, getting from mongo and adding to cache again");
		
		Config configFromMongo = configDao.getConfig(tenantId);
		
		cacheService.addConfigToCache(tenantId, configFromMongo);
		
		return configFromMongo;
	}
	
	public Config updateConfig(Config newConfig) {
		return configDao.updateConfig(newConfig);
	}

}
