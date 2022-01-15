package com.practice.symphony.configservice.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class CacheService {

	private static final Integer EXPIRE_AFTER = 5;

	private LoadingCache<Integer, Object> configCache;

	public CacheService() {
		this.configCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_AFTER, TimeUnit.MINUTES)
				.build(new CacheLoader<Integer, Object>() {

					@Override
					public Object load(Integer key) throws Exception {
						// TODO Auto-generated method stub
						return 0;
					}

				});

	}
	
	public void addConfigToCache(int tenantId,Object object) {
		
		configCache.put(tenantId, object);
	}
	
	public Object getConfig(int tenantId) {
		Object configJsonObject = null;
		try {
			  configJsonObject= configCache.get(tenantId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return configJsonObject;
	}
	
	public LoadingCache<Integer,Object> getLoadingCache(){
		return configCache;
	}
	
	public void clearConfig(int tenantId) {
		configCache.invalidate(tenantId);
	}

}
