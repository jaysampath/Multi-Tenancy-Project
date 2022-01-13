package com.practice.symphony.coreservice.controller;

import com.practice.symphony.coreservice.config.ConfigurationStore;
import com.practice.symphony.coreservice.config.FileConfigurationStore;
import com.practice.symphony.coreservice.config.TenantContext;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreServiceController {

    @Qualifier("fileConfigurationStore")
    @Autowired
    private ConfigurationStore store;

    @GetMapping("/config")
    public JSONObject getConfig(){
        int id=0;
        id = TenantContext.getTenantId();
        if(id==0){
            throw new RuntimeException("Something went wrong while setting up context");
         }
        JSONObject properties = store.getProperty();

        //return "hello from tenant -"+id + " \nwith property of tenant - \n 'account' : "+property;
        return properties;
    }
}
