package com.example.demo_factory_method.factory;

import com.example.demo_factory_method.domain.Notification;
import com.example.demo_factory_method.domain.NotificationType;
import com.example.demo_factory_method.domain.WhatsAppNotification;
import org.springframework.stereotype.Component;

@Component("whatsAppNotificationFactory")
public class WhatsAppNotificationFactory extends NotificationFactory{
    @Override
    Notification createNotification() {
        return new WhatsAppNotification();
    }
}
