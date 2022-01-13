package com.practice.symphony.coreservice.config;


import org.json.simple.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public interface ConfigurationStore {

    public JSONObject getProperty();
}
