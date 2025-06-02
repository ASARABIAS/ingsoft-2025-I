package com.abstractfactory.example.domain.ui;

import org.springframework.stereotype.Component;

@Component
public class LightButton implements Button{
    @Override
    public String render() {
        return "<button class=\"btn btn-primary\">Buscar</button>";
    }
}
