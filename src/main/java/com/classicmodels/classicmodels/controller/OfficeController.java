package com.classicmodels.classicmodels.controller;

import com.classicmodels.classicmodels.entities.Office;
import com.classicmodels.classicmodels.service.office.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @GetMapping
    public ResponseEntity<List<Office>> getOffices() {
        List<Office> offices = officeService.getAllOffices();
        return  new ResponseEntity<>(offices, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveOffice(@RequestBody Office office) {

        office = officeService.saveOffice(office);

        log.info("\nSaving office with code: {}", office.getOfficeCode());
        return ResponseEntity.ok("Office saved successfully with code: " + office.getOfficeCode());
    }
}