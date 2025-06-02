package com.abstractfactory.example.service;

import com.abstractfactory.example.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getAllProducts() {

        return Arrays.asList(
                new Product(1L, "Laptop", 1200.0, 10),
                new Product(2L, "Smartphone", 800.0, 15),
                new Product(3L, "Tablet", 350.0, 8),
                new Product(4L, "Monitor", 200.0, 20)
        );
    }
}
