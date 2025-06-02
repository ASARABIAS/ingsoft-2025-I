package com.designa_patterns.prototype.insfraestructura;

import com.designa_patterns.prototype.dominio.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProductRepository {
    private final Map<String, Product> products = new ConcurrentHashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    public Product save(Product product) {
        products.put(product.getId(), product);
        logger.debug("Producto guardado: {}", product.getId());
        return product;
    }

    public Optional<Product> findById(String id) {
        System.out.println(products.get(id));
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public void deleteById(String id) {
        products.remove(id);
        logger.debug("Producto eliminado: {}", id);
    }

    public boolean existsById(String id) {
        return products.containsKey(id);
    }
}
