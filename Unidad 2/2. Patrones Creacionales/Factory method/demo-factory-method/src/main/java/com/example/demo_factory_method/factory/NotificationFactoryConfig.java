package com.example.demo_factory_method.factory;


import com.example.demo_factory_method.domain.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotificationFactoryConfig {

    private Map<NotificationType, NotificationFactory> factoryMap = new HashMap<>();

    public NotificationFactoryConfig() {
        factoryMap.put(NotificationType.SMS, new SmsNotificationFactory());
        factoryMap.put(NotificationType.EMAIL, new EmailNotificationFactory());
        factoryMap.put(NotificationType.WHATSAPP, new WhatsAppNotificationFactory());
    }

    public NotificationFactory configFactory(NotificationType type) {
        switch (type) {
            case EMAIL:
               return new EmailNotificationFactory();
            case SMS:
                return new SmsNotificationFactory();
            case WHATSAPP:
                return new WhatsAppNotificationFactory();
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado: " + type);
        }
    }

    public NotificationFactory getFactory(NotificationType type) {

        NotificationFactory factory = factoryMap.get(type);

        if (factory == null)
                throw new IllegalArgumentException("Tipo de notificación no soportado: " + type);

        return factory;
    }
}
