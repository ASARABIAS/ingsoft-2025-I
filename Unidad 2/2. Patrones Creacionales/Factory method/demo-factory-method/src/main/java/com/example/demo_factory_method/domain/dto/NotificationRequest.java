package com.example.demo_factory_method.domain.dto;

import com.example.demo_factory_method.domain.NotificationType;

public class NotificationRequest {
    private NotificationType type;
    private String recipient;
    private String message;

    // Constructores
    public NotificationRequest() {}

    public NotificationRequest(NotificationType type, String recipient, String message) {
        this.type = type;
        this.recipient = recipient;
        this.message = message;
    }

    // Getters y Setters
    public NotificationType getType() { return type; }
    public void setType(NotificationType type) { this.type = type; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
