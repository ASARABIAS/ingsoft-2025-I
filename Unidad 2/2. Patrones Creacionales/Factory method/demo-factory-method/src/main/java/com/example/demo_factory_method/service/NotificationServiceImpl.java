package com.example.demo_factory_method.service;


import com.example.demo_factory_method.domain.Notification;
import com.example.demo_factory_method.domain.dto.NotificationRequest;
import com.example.demo_factory_method.domain.dto.NotificationResponse;
import com.example.demo_factory_method.factory.NotificationFactory;
import com.example.demo_factory_method.factory.NotificationFactoryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    private NotificationFactory notificationFactory;
    @Autowired
    private NotificationFactoryConfig factoryConfig;

    @Override
    public NotificationResponse sendNotification(NotificationRequest request) {
        try {
            logger.info("Procesando notificación de tipo: {}", request.getType());

            // Validaciones básicas
            if (request.getRecipient() == null || request.getRecipient().trim().isEmpty()) {
                return new NotificationResponse(false, "El destinatario es requerido", request.getType().toString());
            }

            if (request.getMessage() == null || request.getMessage().trim().isEmpty()) {
                return new NotificationResponse(false, "El mensaje es requerido", request.getType().toString());
            }

            // Crear notificación usando Factory Method
            //notificationFactory=factoryConfig.configFactory(request.getType());
            notificationFactory=factoryConfig.getFactory(request.getType());
            Notification notification = notificationFactory.getNotification();

            // Enviar notificación
            notification.send(request.getRecipient(), request.getMessage());

            logger.info("Notificación enviada exitosamente");
            return new NotificationResponse(true, "Notificación enviada exitosamente", notification.getType());

        } catch (Exception e) {
            logger.error("Error al enviar notificación: {}", e.getMessage());
            return new NotificationResponse(false, "Error al enviar notificación: " + e.getMessage(), request.getType().toString());
        }
    }
}
