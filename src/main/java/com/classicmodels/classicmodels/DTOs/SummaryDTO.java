package com.classicmodels.classicmodels.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SummaryDTO {
    private long totalCustomers;
    private long totalOrders;
    private long totalProducts;
}
