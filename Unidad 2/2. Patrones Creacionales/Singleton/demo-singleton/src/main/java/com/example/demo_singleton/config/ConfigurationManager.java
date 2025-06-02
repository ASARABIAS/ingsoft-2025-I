package com.example.demo_singleton.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    // Instancia única (eager initialization o inicialización temprana)
    private static final ConfigurationManager instance = new ConfigurationManager();

    private Properties config;

    // Constructor privado para evitar instanciación externa
    private ConfigurationManager() {
        loadConfiguration();
    }

    private void loadConfiguration() {
        config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                config.load(input);
            } else {
                throw new RuntimeException("Archivo de configuración no encontrado");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error cargando configuración", e);
        }
    }

    public static ConfigurationManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return config.getProperty(key);
    }
}
