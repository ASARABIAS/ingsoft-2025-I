package com.example.demo_factory_method.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotification implements Notification {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotification.class);

    @Override
    public void send(String recipient, String message) {
        // Simulación del envío de email
        logger.info("Enviando EMAIL a: {} con mensaje: {}", recipient, message);

        // Aquí iría la lógica real de envío de email
        // Por ejemplo, usando JavaMailSender
        try {
            Thread.sleep(1000); // Simular procesamiento
            logger.info("EMAIL enviado exitosamente a: {}", recipient);
        } catch (InterruptedException e) {
            logger.error("Error al enviar EMAIL: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}