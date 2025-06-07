package com.biblioteca.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).authenticated()  // ✅ acceso libre a H2 Console
                        .anyRequest().authenticated()                     // ✅ acceso libre a todo
                )
                .httpBasic(withDefaults())          // ✅ Permite usar Postman o curl
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.disable())                      // ✅ desactiva CSRF
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable())  // ✅ permite iframes
                )
                .build();
    }
}