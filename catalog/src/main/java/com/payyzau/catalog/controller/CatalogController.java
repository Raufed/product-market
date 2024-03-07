package com.payyzau.catalog.controller;

import com.payyzau.catalog.entity.Product;
import com.payyzau.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {

    private CatalogService catalogService;
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public CatalogController(CatalogService catalogService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.catalogService = catalogService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("products")
    public List<Product> getAllProducts() {
        return catalogService.getAllProducts();
    }
    @GetMapping(path = "products/{productId}")
    public Optional<Product> getProductById (@PathVariable("productId") Long productId) {
        return catalogService.getProductById(productId);
    }

    @PostMapping("product")
    public void addProduct(@RequestBody Product product) {
        Product saveProduct = catalogService.addProduct(product);
        kafkaTemplate.send("newProduct", saveProduct);
    }
}
