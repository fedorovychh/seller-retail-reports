package com.app.sellerretailreports.dto.report;

import com.app.sellerretailreports.entity.report.SalesByAsin;
import com.app.sellerretailreports.entity.report.TrafficByAsin;
import lombok.Data;

@Data
public class SalesAndTrafficByAsinDto {
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
