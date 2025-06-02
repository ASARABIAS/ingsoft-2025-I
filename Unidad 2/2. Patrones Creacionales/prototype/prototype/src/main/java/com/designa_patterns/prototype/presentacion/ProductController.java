package com.designa_patterns.prototype.presentacion;

import com.designa_patterns.prototype.aplicacion.CreateProductRequest;
import com.designa_patterns.prototype.aplicacion.ProductResponse;
import com.designa_patterns.prototype.aplicacion.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/prototypes")
    public ResponseEntity<List<String>> getAvailablePrototypes() {
        List<String> prototypes = productService.getAvailablePrototypes();
        return ResponseEntity.ok(prototypes);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        try {
            ProductResponse product = productService.createProductFromPrototype(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        //System.out.println("Id find="+id);
        return productService.getProductById(id)
                .map(product -> ResponseEntity.ok(product))
                .orElse(ResponseEntity.notFound().build());
    }
}
