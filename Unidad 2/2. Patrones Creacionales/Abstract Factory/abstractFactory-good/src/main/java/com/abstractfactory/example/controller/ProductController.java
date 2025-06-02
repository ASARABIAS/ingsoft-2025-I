package com.abstractfactory.example.controller;

import com.abstractfactory.example.domain.model.*;
import com.abstractfactory.example.service.ProductService;
import com.abstractfactory.example.service.UIManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UIManagerService uiManagerService;

    @Autowired
    public ProductController(ProductService productService, UIManagerService uiManagerService) {
        this.productService = productService;
        this.uiManagerService = uiManagerService;
    }

    @GetMapping("/")
    public String index(@RequestParam(name = "theme",required = false) String themeParam, Model model) {

        //String themeParam = Theme.DARK.toString();
        if(themeParam==null){
            themeParam = "DARK";
        }

        Theme theme = Theme.valueOf(themeParam.toUpperCase());
        uiManagerService.setTheme(theme);
        List<Product> products = productService.getAllProducts();

        // Agregar datos al modelo
        model.addAttribute("products", products);
        model.addAttribute("themeClass", uiManagerService.getThemeClass(theme));
        model.addAttribute("currentTheme", theme.toString());
        model.addAttribute("buttonHtml", uiManagerService.getButtonHtml());
        model.addAttribute("textFieldHtml", uiManagerService.getTextFieldHtml());
        model.addAttribute("tableHtml", uiManagerService.getTableHtml(products));

        return "index";
    }
}
