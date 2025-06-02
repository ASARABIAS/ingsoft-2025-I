package com.designa_patterns.prototype.insfraestructura;

import com.designa_patterns.prototype.dominio.Product;
import com.designa_patterns.prototype.dominio.ProductPrototype;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductPrototypeRegistry {
    private final Map<String, ProductPrototype> prototypes = new ConcurrentHashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(ProductPrototypeRegistry.class);

    @PostConstruct
    public void initializePrototypes() {
        logger.info("Inicializando prototipos de productos...");

        // Prototipo de Laptop
        Product laptopPrototype = new Product("LAPTOP_PROTO", "Laptop Base", "Electronics", 999.99);
        laptopPrototype.addFeature("WiFi");
        laptopPrototype.addFeature("Bluetooth");
        laptopPrototype.addSpecification("RAM", "8GB");
        laptopPrototype.addSpecification("Storage", "256GB SSD");
        laptopPrototype.addSpecification("Screen", "15.6 inch");
        laptopPrototype.setDescription("Laptop básica para uso general");

        // Prototipo de Smartphone
        Product phonePrototype = new Product("PHONE_PROTO", "Smartphone Base", "Electronics", 699.99);
        phonePrototype.addFeature("4G");
        phonePrototype.addFeature("Camera");
        phonePrototype.addFeature("GPS");
        phonePrototype.addSpecification("RAM", "6GB");
        phonePrototype.addSpecification("Storage", "128GB");
        phonePrototype.addSpecification("Screen", "6.1 inch");
        phonePrototype.setDescription("Smartphone básico con funcionalidades estándar");

        // Prototipo de Tablet
        Product tabletPrototype = new Product("TABLET_PROTO", "Tablet Base", "Electronics", 499.99);
        tabletPrototype.addFeature("WiFi");
        tabletPrototype.addFeature("Touch Screen");
        tabletPrototype.addSpecification("RAM", "4GB");
        tabletPrototype.addSpecification("Storage", "64GB");
        tabletPrototype.addSpecification("Screen", "10.1 inch");
        tabletPrototype.setDescription("Tablet básica para entretenimiento");

        registerPrototype("laptop", laptopPrototype);
        registerPrototype("smartphone", phonePrototype);
        registerPrototype("tablet", tabletPrototype);

        logger.info("Prototipos inicializados: {}", prototypes.keySet());
    }

    public void registerPrototype(String key, ProductPrototype prototype) {
        prototypes.put(key.toLowerCase(), prototype);
        logger.debug("Prototipo registrado: {}", key);
    }

    public ProductPrototype getPrototype(String key) {
        ProductPrototype prototype = prototypes.get(key.toLowerCase());
        if (prototype == null) {
            throw new IllegalArgumentException("Prototipo no encontrado: " + key);
        }
        return prototype.clone();
    }

    public Set<String> getAvailablePrototypes() {
        return new HashSet<>(prototypes.keySet());
    }

    public boolean hasPrototype(String key) {
        return prototypes.containsKey(key.toLowerCase());
    }
}

