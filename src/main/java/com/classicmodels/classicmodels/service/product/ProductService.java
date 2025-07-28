package com.classicmodels.classicmodels.service.product;

import com.classicmodels.classicmodels.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(String productCode);
    Product save(Product product);
    void deleteById(String productCode);
}

