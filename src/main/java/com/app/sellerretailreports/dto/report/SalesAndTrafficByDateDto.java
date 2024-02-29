package com.app.sellerretailreports.dto.report;

import com.app.sellerretailreports.entity.report.SalesByDate;
import com.app.sellerretailreports.entity.report.TrafficByDate;
import java.time.LocalDate;
import lombok.Data;

@Data
public class SalesAndTrafficByDateDto {
    private LocalDate date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
