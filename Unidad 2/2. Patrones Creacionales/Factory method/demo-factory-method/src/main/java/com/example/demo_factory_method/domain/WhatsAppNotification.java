package com.example.demo_factory_method.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhatsAppNotification implements Notification {
    private static final Logger logger = LoggerFactory.getLogger(WhatsAppNotification.class);

    @Override
    public void send(String recipient, String message) {
        // Simulación del envío de WhatsApp
        logger.info("Enviando WHATSAPP a: {} con mensaje: {}", recipient, message);

        // Aquí iría la lógica real de envío de WhatsApp
        // Por ejemplo, usando WhatsApp Business API
        try {
            Thread.sleep(1200); // Simular procesamiento
            logger.info("WHATSAPP enviado exitosamente a: {}", recipient);
        } catch (InterruptedException e) {
            logger.error("Error al enviar WHATSAPP: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String getType() {
        return "WHATSAPP";
    }
}