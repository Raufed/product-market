package com.payyzau.catalog.service;

import com.payyzau.catalog.entity.Product;
import com.payyzau.catalog.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    private CatalogRepository catalogRepository;
    @Autowired
    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public Optional<Product> getProductById (Long productid) {
        return catalogRepository.findById(productid);
    }

    public List<Product> getAllProducts() {
        return catalogRepository.findAll();
    }
    public Product addProduct(Product product) {
        return catalogRepository.save(product);
    }
}
