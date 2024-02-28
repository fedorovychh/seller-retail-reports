package com.app.sellerretailreports.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class SaleAndTrafficByDate {
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
