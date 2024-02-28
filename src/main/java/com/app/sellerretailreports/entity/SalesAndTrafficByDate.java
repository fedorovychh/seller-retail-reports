package com.app.sellerretailreports.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SalesAndTrafficByDate {
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
