package com.classicmodels.classicmodels.controller;

import com.classicmodels.classicmodels.entities.Productline;
import com.classicmodels.classicmodels.service.productline.ProductlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productlines")
@RequiredArgsConstructor
public class ProductlineController {

    private final ProductlineService productlineService;

    @GetMapping
    public ResponseEntity<List<Productline>> getAll() {
        return ResponseEntity.ok(productlineService.findAll());
    }

    @GetMapping("/{productLine}")
    public ResponseEntity<Productline> getById(@PathVariable String productLine) {
        return productlineService.findById(productLine)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Productline> create(@RequestBody Productline productline) {
        return ResponseEntity.ok(productlineService.save(productline));
    }

    @PutMapping("/{productLine}")
    public ResponseEntity<Productline> update(@PathVariable String productLine, @RequestBody Productline updatedProductline) {
        return productlineService.findById(productLine)
                .map(pl -> {
                    updatedProductline.setProductLine(productLine);
                    return ResponseEntity.ok(productlineService.save(updatedProductline));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productLine}")
    public ResponseEntity<Void> delete(@PathVariable String productLine) {
        productlineService.deleteById(productLine);
        return ResponseEntity.noContent().build();
    }
}

