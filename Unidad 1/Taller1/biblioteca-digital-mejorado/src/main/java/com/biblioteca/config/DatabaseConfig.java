package com.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import java.util.logging.Logger;

@Configuration
public class DatabaseConfig {
    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());

    @Bean
    @Primary
    public DataSource dataSource() {
        logger.info("Configurando datasource principal");

        // VIOLACIÓN SRP: Configuración con lógica de validación
        String url = System.getProperty("db.url", "jdbc:h2:mem:biblioteca");
        if (!esUrlValida(url)) {
            logger.warning("URL de base de datos inválida, usando H2 por defecto");
            url = "jdbc:h2:mem:biblioteca";
        }

        return DataSourceBuilder.create()
                .url(url)
                .username("sa")
                .password("")
                .driverClassName("org.h2.Driver")
                .build();
    }

    // VIOLACIÓN SRP: Clase de configuración con validación
    private boolean esUrlValida(String url) {
        return url != null && (url.startsWith("jdbc:h2:") ||
                url.startsWith("jdbc:mysql:") ||
                url.startsWith("jdbc:postgresql:"));
    }

    // VIOLACIÓN: Lógica de negocio en configuración
    @Bean
    public int obtenerLimitePrestamosDefault() {
        String ambiente = System.getProperty("app.environment", "development");
        logger.info("Configurando límites para ambiente: " + ambiente);

        // Lógica de negocio hardcodeada en configuración
        if ("production".equals(ambiente)) {
            return 5;
        } else if ("staging".equals(ambiente)) {
            return 8;
        } else {
            return 10; // development
        }
    }
}
