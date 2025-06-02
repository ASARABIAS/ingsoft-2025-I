package com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BibliotecaDigitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(BibliotecaDigitalApplication.class, args);
    }
}
