package com.example.demo_singleton.service;

import com.example.demo_singleton.config.ConfigurationManager;
import com.example.demo_singleton.config.DIConfiguratonManager;
import com.example.demo_singleton.config.LazyConfigurationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingletonService {

    private  ConfigurationManager config;
    private  LazyConfigurationManager lazyConfig;
    @Autowired
    private DIConfiguratonManager DIConfig;

    private SingletonService() {}


    public String getKeyValue(String key){
        config = ConfigurationManager.getInstance();

        if(config.getValue(key)==null)
            throw new IllegalArgumentException("Key not found");

        return config.getValue(key);
    }

    public String getLazyKeyValue(String key){
        lazyConfig = LazyConfigurationManager.getInstance();

        if(lazyConfig.getValue(key)==null)
            throw new IllegalArgumentException("Key not found");

        return lazyConfig.getValue(key);
    }

    public String getDIKeyValue(String key){

        if(DIConfig.getValue(key)==null)
            throw new IllegalArgumentException("Key not found");

        return DIConfig.getValue(key);
    }



}
