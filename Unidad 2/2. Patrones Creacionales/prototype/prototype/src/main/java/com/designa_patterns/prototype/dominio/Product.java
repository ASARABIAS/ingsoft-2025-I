package com.designa_patterns.prototype.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product implements ProductPrototype {
    private String id;
    private String name;
    private String category;
    private Double price;
    private Map<String, Object> specifications;
    private List<String> features;
    private String description;

    public Product() {
        this.specifications = new HashMap<>();
        this.features = new ArrayList<>();
    }

    public Product(String id, String name, String category, Double price) {
        this();
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Implementación del patrón Prototype
    @Override
    public Product clone() {
        try {
            Product cloned = (Product) super.clone();
            // Deep copy para objetos mutables
            cloned.specifications = new HashMap<>(this.specifications);
            cloned.features = new ArrayList<>(this.features);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error clonando producto", e);
        }
    }

    @Override
    public String getProductInfo() {
        return String.format("Product[id=%s, name=%s, category=%s, price=%.2f, features=%d]",
                id, name, category, price, features.size());
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Map<String, Object> getSpecifications() { return specifications; }
    public void setSpecifications(Map<String, Object> specifications) {
        this.specifications = specifications;
    }

    public List<String> getFeatures() { return features; }
    public void setFeatures(List<String> features) { this.features = features; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public void addFeature(String feature) {
        this.features.add(feature);
    }

    public void addSpecification(String key, Object value) {
        this.specifications.put(key, value);
    }
}
