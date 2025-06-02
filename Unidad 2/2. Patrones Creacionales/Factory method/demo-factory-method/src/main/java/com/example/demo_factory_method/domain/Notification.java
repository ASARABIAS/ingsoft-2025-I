package com.example.demo_factory_method.domain;


public interface Notification {
    void send(String recipient, String message);
    String getType();
}