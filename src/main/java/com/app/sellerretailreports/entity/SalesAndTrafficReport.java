package com.app.sellerretailreports.entity;

import lombok.Data;

@Data
public class SalesAndTrafficReport {
    private ReportSpecification reportSpecification;
    private SalesAndTrafficByDate salesAndTrafficByDate;
    private SalesAndTrafficByAsin salesAndTrafficByAsin;
}
