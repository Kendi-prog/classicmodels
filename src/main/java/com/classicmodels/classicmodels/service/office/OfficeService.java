package com.classicmodels.classicmodels.service.office;

import com.classicmodels.classicmodels.entities.Office;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfficeService {
    Office saveOffice(Office office);
    String generateOfficeId();
    List<Office> getAllOffices();
}