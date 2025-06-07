package com.biblioteca.service;

import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class NotificacionService {
    private static final Logger logger = Logger.getLogger(NotificacionService.class.getName());

    // VIOLACIÓN OCP: Difícil agregar nuevos tipos de notificación
    public String enviarEmail(String destinatario, String mensaje) {
        // Simulación de envío de email
        String email="EMAIL enviado a: " + destinatario + " - " + mensaje;
        logger.info(email);

        // VIOLACIÓN SRP: Lógica de logging mezclada con envío
        registrarEnLog("EMAIL", destinatario, mensaje);
        return email;
    }

    public void enviarSMS(String telefono, String mensaje) {
        // Simulación de envío de SMS
        logger.info("SMS enviado a: " + telefono + " - " + mensaje);
        registrarEnLog("SMS", telefono, mensaje);
    }

    // VIOLACIÓN: Si queremos agregar WhatsApp, Slack, etc., hay que modificar esta clase
    public void enviarWhatsApp(String telefono, String mensaje) {
        logger.info("WhatsApp enviado a: " + telefono + " - " + mensaje);
        registrarEnLog("WHATSAPP", telefono, mensaje);
    }

    private void registrarEnLog(String tipo, String destinatario, String mensaje) {
        // Simulación de registro en base de datos
        logger.info(String.format("LOG: %s -> %s: %s", tipo, destinatario, mensaje));
    }

    // VIOLACIÓN SRP: NotificacionService también valida formatos
    public boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("\\d{10}");
    }
}
