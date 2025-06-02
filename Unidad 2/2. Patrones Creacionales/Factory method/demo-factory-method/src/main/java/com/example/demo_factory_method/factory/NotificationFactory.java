package com.example.demo_factory_method.factory;


import com.example.demo_factory_method.domain.Notification;
import com.example.demo_factory_method.domain.NotificationType;
import org.springframework.stereotype.Component;

public abstract class NotificationFactory {

    public Notification getNotification(){
        return this.createNotification();
    }

    abstract Notification createNotification();
}