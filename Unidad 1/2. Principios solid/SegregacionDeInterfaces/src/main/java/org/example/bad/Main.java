package org.example.bad;

public class Main {
    public static void main(String[] args) {
        SmartWatch sw = new SmartWatch();
        System.out.println(sw.getDateTime());
        System.out.println(sw.getTime());
        System.out.println(sw.getEmailNotifications());
        System.out.println(sw.getWhatsAppNotifications());
        System.out.println(sw.getAlarm());
        System.out.println("Hello world!");
    }
}