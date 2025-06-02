package com.abstractfactory.example.domain.ui;

import com.abstractfactory.example.domain.model.Product;
import com.abstractfactory.example.domain.model.Theme;
import org.springframework.stereotype.Component;

@Component
public class UIComponent {

    public UIComponent() {
    }

    public String renderButton(Theme theme) {
        if (theme == Theme.DARK) {
            return "<button class=\"btn btn-secondary\">Buscar</button>";
        } else {
            return "<button class=\"btn btn-primary\">Buscar</button>";
        }
    }

    public String renderTextField(Theme theme) {
        if (theme == Theme.DARK) {
            return "<input type=\"text\" class=\"form-control bg-dark text-light\" placeholder=\"Buscar productos...\">";
        } else {
            return "<input type=\"text\" class=\"form-control bg-light\" placeholder=\"Buscar productos...\">";
        }
    }

    public String renderTable(Theme theme, java.util.List<?> data) {
        StringBuilder html = new StringBuilder();

        if (theme == Theme.DARK) {
            html.append("<table class=\"table table-striped table-dark\">");
        } else {
            html.append("<table class=\"table table-striped table-light\">");
        }

        html.append("<thead><tr>");
        html.append("<th>ID</th>");
        html.append("<th>Nombre</th>");
        html.append("<th>Precio</th>");
        html.append("<th>Stock</th>");
        html.append("</tr></thead>");
        html.append("<tbody>");

        for (Object obj : data) {
            if (obj instanceof Product product) {
                html.append("<tr>");
                html.append("<td>").append(product.getId()).append("</td>");
                html.append("<td>").append(product.getName()).append("</td>");
                html.append("<td>$").append(product.getPrice()).append("</td>");
                html.append("<td>").append(product.getStock()).append("</td>");
                html.append("</tr>");
            }
        }

        html.append("</tbody></table>");
        return html.toString();
    }

    public String getThemeClass(Theme theme) {
        return theme == Theme.DARK ? "bg-dark text-light" : "bg-light text-dark";
    }
}

