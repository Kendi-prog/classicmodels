package com.classicmodels.classicmodels.service;

import com.classicmodels.classicmodels.entities.Office;
import com.classicmodels.classicmodels.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OfficeServiceImplementation implements  OfficeService {
    private final OfficeRepository officeRepository;


    @Override
    public Office saveOffice(Office office) {

        String generatedCode = generateOfficeId();

        office.setOfficeCode(generatedCode);

        log.error("Office code generated code is {} {}", generatedCode, office.getPostalCode() );
        return officeRepository.save(office);
    }

    @Override
    public String generateOfficeId() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7);
        return "OFF" + uuid; // Ensures length <= 10 (OFF + 7 chars)
    }

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }
}