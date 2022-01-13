package com.practice.symphony.configservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.symphony.configservice.dao.ConfigDao;
import com.practice.symphony.configservice.entity.Config;

public class ConfigService {
	
	@Autowired
	private ConfigDao configDao;
	
	public Config getConfig(int tenantId) {
		return configDao.getConfig(tenantId);
	}
	
	public Config updateConfig(Config newConfig) {
		return configDao.updateConfig(newConfig);
	}

}
