package com.abstractfactory.example.service;

import com.abstractfactory.example.domain.factory.DarkUIFactory;
import com.abstractfactory.example.domain.factory.LightUIFactory;
import com.abstractfactory.example.domain.factory.UIFactory;
import com.abstractfactory.example.domain.model.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    private final LightUIFactory lightUIFactory;
    private final DarkUIFactory darkUIFactory;

    @Autowired
    public ThemeService(LightUIFactory lightUIFactory, DarkUIFactory darkUIFactory) {
        this.lightUIFactory = lightUIFactory;
        this.darkUIFactory = darkUIFactory;
    }

    public UIFactory getFactory(Theme theme) {
        return switch (theme) {
            case DARK -> darkUIFactory;
            case LIGHT -> lightUIFactory;
            default -> lightUIFactory;
        };
    }
}
