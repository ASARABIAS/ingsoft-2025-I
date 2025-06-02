package com.abstractfactory.example.domain.ui;
import java.util.List;
import com.abstractfactory.example.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class LightTable implements Table{
    @Override
    public String render(List<?> data) {
        StringBuilder html = new StringBuilder();
        html.append("<table class=\"table table-striped table-light\">");
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
}
