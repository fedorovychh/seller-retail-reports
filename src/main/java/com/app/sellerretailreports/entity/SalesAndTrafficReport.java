package com.app.sellerretailreports.entity;

import lombok.Data;

@Data
public class SalesAndTrafficReport {
    private ReportSpecification reportSpecification;
    private SaleAndTrafficByDate saleAndTrafficByDate;
    private SalesAndTrafficByAsin salesAndTrafficByAsin;
}
