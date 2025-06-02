package com.abstractfactory.example.domain.ui;

import org.springframework.stereotype.Component;

@Component
public class LightTextField implements TextField{
    @Override
    public String render() {
        return "<input type=\"text\" class=\"form-control bg-light\" placeholder=\"Buscar productos...\">";
    }
}
