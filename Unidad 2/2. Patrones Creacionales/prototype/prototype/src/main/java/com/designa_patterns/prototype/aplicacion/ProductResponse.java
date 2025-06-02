package com.designa_patterns.prototype.aplicacion;

import com.designa_patterns.prototype.dominio.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductResponse {
    private String id;
    private String name;
    private String category;
    private Double price;
    private Map<String, Object> specifications;
    private List<String> features;
    private String description;
    private LocalDateTime createdAt;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.specifications = new HashMap<>(product.getSpecifications());
        this.features = new ArrayList<>(product.getFeatures());
        this.description = product.getDescription();
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Double getPrice() { return price; }
    public Map<String, Object> getSpecifications() { return specifications; }
    public List<String> getFeatures() { return features; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

