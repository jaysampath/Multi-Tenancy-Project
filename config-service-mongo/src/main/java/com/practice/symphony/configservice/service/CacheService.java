package com.practice.symphony.configservice.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.practice.symphony.configservice.entity.Config;

@Service
public class CacheService {

	private static final Integer EXPIRE_AFTER = 5;

	private LoadingCache<Integer, Config> configCache;
	
	Logger logger = LoggerFactory.getLogger(CacheService.class);

	public CacheService() {
		configCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_AFTER, TimeUnit.MINUTES)
				.build(new CacheLoader<Integer, Config>() {

					@Override
					public Config load(Integer key) throws Exception {
						// TODO Auto-generated method stub
						return null;
					}

				});

	}
	
	public void addConfigToCache(int tenantId,Config object) {
		
		configCache.put(tenantId, object);
	}
	
	public Object getConfig(int tenantId) {
		Object configJsonObject = null;
		try {
			  configJsonObject= configCache.get(tenantId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info("no cache object found for tenant id- {}",tenantId);
		}
		return configJsonObject;
	}
	
	public LoadingCache<Integer,Config> getLoadingCache(){
		return configCache;
	}
	
	public void clearConfig(int tenantId) {
		configCache.invalidate(tenantId);
	}

}
