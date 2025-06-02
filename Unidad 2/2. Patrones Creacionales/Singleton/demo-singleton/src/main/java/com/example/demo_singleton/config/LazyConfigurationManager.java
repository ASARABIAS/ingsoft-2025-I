package com.example.demo_singleton.config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LazyConfigurationManager {

    // Instancia única (Lazy initialization o inicialización perezoza)
    private static LazyConfigurationManager instance ;

    private Properties config;

    // Constructor privado para evitar instanciación externa
    private LazyConfigurationManager() {
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

    public static LazyConfigurationManager getInstance() {
        if(instance == null) {
            synchronized (LazyConfigurationManager.class){
                //Es posible que otro hilo ya haya creado la instancia mientras el hilo actual esperaba el bloqueo.
                if(instance == null) {
                    instance=new LazyConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getValue(String key) {
        return config.getProperty(key);
    }
}
