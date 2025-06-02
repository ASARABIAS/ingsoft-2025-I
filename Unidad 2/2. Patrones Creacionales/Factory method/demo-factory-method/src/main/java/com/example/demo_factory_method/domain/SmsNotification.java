package com.example.demo_factory_method.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsNotification implements Notification {
    private static final Logger logger = LoggerFactory.getLogger(SmsNotification.class);

    @Override
    public void send(String recipient, String message) {
        // Simulación del envío de SMS
        logger.info("Enviando SMS a: {} con mensaje: {}", recipient, message);

        // Aquí iría la lógica real de envío de SMS
        // Por ejemplo, usando Twilio API
        try {
            Thread.sleep(800); // Simular procesamiento
            logger.info("SMS enviado exitosamente a: {}", recipient);
        } catch (InterruptedException e) {
            logger.error("Error al enviar SMS: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String getType() {
        return "SMS";
    }
}
