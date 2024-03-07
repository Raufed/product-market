package com.payyzau.catalog.repository;

import com.payyzau.catalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Product,Long> {
}
