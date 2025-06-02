package com.abstractfactory.example.domain.ui;

import org.springframework.stereotype.Component;

@Component
public class DarkButton implements Button{
    @Override
    public String render() {
        return "<button class=\"btn btn-secondary\">Buscar</button>";
    }
}
