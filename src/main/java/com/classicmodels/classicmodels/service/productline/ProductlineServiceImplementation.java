package com.classicmodels.classicmodels.service.productline;

import com.classicmodels.classicmodels.entities.Productline;
import com.classicmodels.classicmodels.repository.ProductlineRepository;
import com.classicmodels.classicmodels.service.productline.ProductlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductlineServiceImplementation implements ProductlineService {

    private final ProductlineRepository productlineRepository;

    @Override
    public List<Productline> findAll() {
        return productlineRepository.findAll();
    }

    @Override
    public Optional<Productline> findById(String productLine) {
        return productlineRepository.findById(productLine);
    }

    @Override
    public Productline save(Productline productline) {
        return productlineRepository.save(productline);
    }

    @Override
    public void deleteById(String productLine) {
        productlineRepository.deleteById(productLine);
    }
}

