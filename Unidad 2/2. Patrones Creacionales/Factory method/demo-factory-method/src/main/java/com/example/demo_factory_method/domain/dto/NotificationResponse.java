package com.example.demo_factory_method.domain.dto;

public class NotificationResponse {
    private boolean success;
    private String message;
    private String type;

    // Constructores
    public NotificationResponse() {}

    public NotificationResponse(boolean success, String message, String type) {
        this.success = success;
        this.message = message;
        this.type = type;
    }

    // Getters y Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
