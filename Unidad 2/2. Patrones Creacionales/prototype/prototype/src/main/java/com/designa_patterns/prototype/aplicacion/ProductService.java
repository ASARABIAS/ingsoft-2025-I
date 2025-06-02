package com.designa_patterns.prototype.aplicacion;

import com.designa_patterns.prototype.dominio.Product;
import com.designa_patterns.prototype.insfraestructura.ProductPrototypeRegistry;
import com.designa_patterns.prototype.insfraestructura.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductPrototypeRegistry prototypeRegistry;
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductPrototypeRegistry prototypeRegistry,
                          ProductRepository productRepository) {
        this.prototypeRegistry = prototypeRegistry;
        this.productRepository = productRepository;
    }

    public ProductResponse createProductFromPrototype(CreateProductRequest request) {
        logger.info("Creando producto desde prototipo: {}", request.getPrototypeKey());

        // Validación
        if (!prototypeRegistry.hasPrototype(request.getPrototypeKey())) {
            throw new IllegalArgumentException("Prototipo no válido: " + request.getPrototypeKey());
        }

        // Clonar prototipo
        Product product = (Product) prototypeRegistry.getPrototype(request.getPrototypeKey());

        // Personalización
        if (request.getCustomId() != null) {
            product.setId(request.getCustomId());
        } else {
            product.setId(generateUniqueId(request.getPrototypeKey()));
        }

        if (request.getCustomName() != null) {
            product.setName(request.getCustomName());
        }

        if (request.getCustomPrice() != null) {
            product.setPrice(request.getCustomPrice());
        }

        // Agregar especificaciones adicionales
        if (request.getAdditionalSpecs() != null) {
            request.getAdditionalSpecs().forEach(product::addSpecification);
        }

        // Agregar características adicionales
        if (request.getAdditionalFeatures() != null) {
            request.getAdditionalFeatures().forEach(product::addFeature);
        }

        // Guardar en repositorio
        Product savedProduct = productRepository.save(product);

        logger.info("Producto creado exitosamente: {}", savedProduct.getProductInfo());
        return new ProductResponse(savedProduct);
    }

    public List<String> getAvailablePrototypes() {
        return new ArrayList<>(prototypeRegistry.getAvailablePrototypes());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    public Optional<ProductResponse> getProductById(String id) {
        //System.out.println(id);
        return productRepository.findById(id)
                .map(ProductResponse::new);
    }

    private String generateUniqueId(String prototypeKey) {
        return prototypeKey.toUpperCase() + "_" +
                System.currentTimeMillis() + "_" +
                (int)(Math.random() * 1000);
    }
}