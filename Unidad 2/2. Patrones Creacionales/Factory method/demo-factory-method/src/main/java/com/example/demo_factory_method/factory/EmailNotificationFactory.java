package com.example.demo_factory_method.factory;

import com.example.demo_factory_method.domain.EmailNotification;
import com.example.demo_factory_method.domain.Notification;
import com.example.demo_factory_method.domain.NotificationType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("emailNotificationFactory")
@Primary
public class EmailNotificationFactory extends NotificationFactory {
    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}
