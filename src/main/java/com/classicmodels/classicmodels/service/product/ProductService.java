package com.classicmodels.classicmodels.service.product;

import com.classicmodels.classicmodels.DTOs.ProductDTO;
import com.classicmodels.classicmodels.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> findAll();
    Optional<ProductDTO> findById(String productCode);
    ProductDTO save(ProductDTO dto);
    ProductDTO updateProduct(String productCode, ProductDTO productDTO);
    void deleteById(String productCode);
}

