package com.abstractfactory.example.service;

import com.abstractfactory.example.domain.factory.UIFactory;
import com.abstractfactory.example.domain.model.Theme;
import com.abstractfactory.example.domain.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UIManagerService {

    private final ThemeService themeService;
    private UIFactory currentFactory;

    @Autowired
    public UIManagerService(ThemeService themeService) {
        this.themeService = themeService;
        // Default to light theme
        this.currentFactory = themeService.getFactory(Theme.LIGHT);
    }

    public void setTheme(Theme theme) {
        this.currentFactory = themeService.getFactory(theme);
    }

    public String getButtonHtml() {
        Button button = currentFactory.createButton();
        return button.render();
    }

    public String getTextFieldHtml() {
        TextField textField = currentFactory.createTextField();
        return textField.render();
    }

    public String getTableHtml(List<?> data) {
        Table table = currentFactory.createTable();
        return table.render(data);
    }

    public String getThemeClass(Theme theme) {
        return theme == Theme.DARK ? "bg-dark text-light" : "bg-light text-dark";
    }
}
