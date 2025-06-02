package com.example.demo_singleton.config;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class DIConfiguratonManager {

    private Properties config;

    private DIConfiguratonManager() {
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

    public String getValue(String key) {
        return config.getProperty(key);
    }

}
