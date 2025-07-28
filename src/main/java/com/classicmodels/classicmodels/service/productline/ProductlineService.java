package com.classicmodels.classicmodels.service.productline;

import com.classicmodels.classicmodels.entities.Productline;

import java.util.List;
import java.util.Optional;

public interface ProductlineService {
    List<Productline> findAll();
    Optional<Productline> findById(String productLine);
    Productline save(Productline productline);
    void deleteById(String productLine);
}

