package com.classicmodels.classicmodels.controller;

import com.classicmodels.classicmodels.entities.Product;
import com.classicmodels.classicmodels.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Product> getById(@PathVariable String productCode) {
        return productService.findById(productCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{productCode}")
    public ResponseEntity<Product> update(@PathVariable String productCode, @RequestBody Product updatedProduct) {
        return productService.findById(productCode)
                .map(product -> {
                    updatedProduct.setProductCode(productCode);
                    return ResponseEntity.ok(productService.save(updatedProduct));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity<Void> delete(@PathVariable String productCode) {
        productService.deleteById(productCode);
        return ResponseEntity.noContent().build();
    }
}

