package com.example.demo_factory_method.factory;

import com.example.demo_factory_method.domain.Notification;
import com.example.demo_factory_method.domain.NotificationType;
import com.example.demo_factory_method.domain.SmsNotification;
import org.springframework.stereotype.Component;

@Component("smsNotificationFactory")
public class SmsNotificationFactory extends NotificationFactory{
    @Override
    Notification createNotification() {
        return new SmsNotification();
    }
}
