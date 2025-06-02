package com.example.demo_factory_method.service;

import com.example.demo_factory_method.domain.dto.NotificationRequest;
import com.example.demo_factory_method.domain.dto.NotificationResponse;

public interface NotificationService {
    NotificationResponse sendNotification(NotificationRequest request);
}
