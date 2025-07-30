package com.classicmodels.classicmodels.controller;

import com.classicmodels.classicmodels.DTOs.SummaryDTO;
import com.classicmodels.classicmodels.service.dashboard.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/summary")
    public ResponseEntity<SummaryDTO> getSummary() {
        return ResponseEntity.ok(dashboardService.getSummary());
    }
}
