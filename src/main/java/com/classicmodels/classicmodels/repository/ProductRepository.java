package com.classicmodels.classicmodels.repository;

import com.classicmodels.classicmodels.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

