package com.abstractfactory.example.domain.factory;


import com.abstractfactory.example.domain.ui.Button;
import com.abstractfactory.example.domain.ui.*;
import com.abstractfactory.example.domain.ui.Table;
import com.abstractfactory.example.domain.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LightUIFactory implements UIFactory{

    private final LightButton lightButton;
    private final LightTextField lightTextField;
    private final LightTable lightTable;

    @Autowired
    public LightUIFactory(LightButton lightButton, LightTextField lightTextField, LightTable lightTable) {
        this.lightButton = lightButton;
        this.lightTextField = lightTextField;
        this.lightTable = lightTable;
    }

    @Override
    public Button createButton() {
        return this.lightButton;
    }

    @Override
    public TextField createTextField() {
        return this.lightTextField;
    }

    @Override
    public Table createTable() {
        return this.lightTable;
    }
}

