package com.classicmodels.classicmodels.service.product;

import com.classicmodels.classicmodels.entities.Product;
import com.classicmodels.classicmodels.repository.ProductRepository;
import com.classicmodels.classicmodels.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String productCode) {
        return productRepository.findById(productCode);
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

