package com.practice.symphony.coreservice.config;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileConfigurationStore implements ConfigurationStore {

    Logger logger = LoggerFactory.getLogger(FileConfigurationStore.class);

    @Override
    public JSONObject getProperty() {
        int tenantId = TenantContext.getTenantId();

        JSONObject properties = readConfigFiles(tenantId);
        logger.info("property of tenant ="+properties);
        return properties;
    }

    public JSONObject readConfigFiles(int tenantId)  {

        JSONParser jsonParser = new JSONParser();
        String account = null;
        JSONObject jsonObject=null,tenant = null;

        try {
            FileReader reader = new FileReader("src/main/resources/"+tenantId+".config.json");

            Object obj = jsonParser.parse(reader);
             jsonObject = (JSONObject) obj;
             tenant = (JSONObject) jsonObject.get("tenant");
             account = (String) tenant.get("account");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
