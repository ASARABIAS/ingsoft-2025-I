package com.abstractfactory.example.service;

import com.abstractfactory.example.domain.model.Theme;
import com.abstractfactory.example.domain.ui.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UIService {

    private final UIComponent uiComponent;
    private Theme currentTheme ;

    @Autowired
    public UIService(UIComponent uiComponent) {
        this.uiComponent = uiComponent;
        this.currentTheme= Theme.LIGHT;
    }

   /* public Theme getCurrentTheme() {
        return currentTheme;
    }
    */

    public void setTheme(Theme theme) {
        this.currentTheme = theme;
    }

    public String getButtonHtml() {
        return uiComponent.renderButton(currentTheme);
    }

    public String getTextFieldHtml() {
        return uiComponent.renderTextField(currentTheme);
    }

    public String getTableHtml(List<?> data) {
        return uiComponent.renderTable(currentTheme, data);
    }

    public String getThemeClass() {
        return uiComponent.getThemeClass(this.currentTheme);
    }
}
