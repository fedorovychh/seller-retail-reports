package com.app.sellerretailreports.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SalesAndTrafficByAsin {
    @Id
    private Long id;
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
