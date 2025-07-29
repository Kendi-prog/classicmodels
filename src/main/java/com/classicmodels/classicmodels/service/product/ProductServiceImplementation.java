package com.classicmodels.classicmodels.service.product;

import com.classicmodels.classicmodels.DTOs.ProductDTO;
import com.classicmodels.classicmodels.entities.Product;
import com.classicmodels.classicmodels.repository.ProductRepository;
import com.classicmodels.classicmodels.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<ProductDTO> findById(String productCode) {
        return productRepository.findById(productCode)
                .map(this::convertToDTO);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(String productCode) {
        productRepository.deleteById(productCode);
    }
}

