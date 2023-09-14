package com.be.model.dto;

import lombok.Data;

@Data
public class MonthlyRevenue {
    private int month;
    private float revenue;

    public MonthlyRevenue(int month, float revenue) {
        this.month = month;
        this.revenue = revenue;
    }
}