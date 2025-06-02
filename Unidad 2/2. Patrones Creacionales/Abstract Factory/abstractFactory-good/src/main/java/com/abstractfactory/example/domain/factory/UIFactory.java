package com.abstractfactory.example.domain.factory;

import com.abstractfactory.example.domain.ui.*;

public interface UIFactory {
    Button createButton();
    TextField createTextField();
    Table createTable();
}
