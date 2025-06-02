package com.designa_patterns.prototype.aplicacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateProductRequest {
    private String prototypeKey;
    private String customId;
    private String customName;
    private Double customPrice;
    private Map<String, Object> additionalSpecs;
    private List<String> additionalFeatures;

    // Constructors
    public CreateProductRequest() {}

    public CreateProductRequest(String prototypeKey, String customId, String customName) {
        this.prototypeKey = prototypeKey;
        this.customId = customId;
        this.customName = customName;
        this.additionalSpecs = new HashMap<>();
        this.additionalFeatures = new ArrayList<>();
    }

    // Getters y Setters
    public String getPrototypeKey() { return prototypeKey; }
    public void setPrototypeKey(String prototypeKey) { this.prototypeKey = prototypeKey; }

    public String getCustomId() { return customId; }
    public void setCustomId(String customId) { this.customId = customId; }

    public String getCustomName() { return customName; }
    public void setCustomName(String customName) { this.customName = customName; }

    public Double getCustomPrice() { return customPrice; }
    public void setCustomPrice(Double customPrice) { this.customPrice = customPrice; }

    public Map<String, Object> getAdditionalSpecs() { return additionalSpecs; }
    public void setAdditionalSpecs(Map<String, Object> additionalSpecs) {
        this.additionalSpecs = additionalSpecs;
    }

    public List<String> getAdditionalFeatures() { return additionalFeatures; }
    public void setAdditionalFeatures(List<String> additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }
}
