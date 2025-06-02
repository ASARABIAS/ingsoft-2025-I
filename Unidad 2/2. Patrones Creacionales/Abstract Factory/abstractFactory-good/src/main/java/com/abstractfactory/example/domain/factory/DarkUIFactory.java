package com.abstractfactory.example.domain.factory;

import com.abstractfactory.example.domain.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DarkUIFactory implements UIFactory {
    private final DarkButton darkButton;
    private final DarkTextField darkTextField;
    private final DarkTable darkTable;

    @Autowired
    public DarkUIFactory(DarkButton darkButton, DarkTextField darkTextField, DarkTable darkTable) {
        this.darkButton = darkButton;
        this.darkTextField = darkTextField;
        this.darkTable = darkTable;
    }

    @Override
    public Button createButton() {
        return darkButton;
    }

    @Override
    public TextField createTextField() {
        return darkTextField;
    }

    @Override
    public Table createTable() {
        return darkTable;
    }
}
