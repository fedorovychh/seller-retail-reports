package com.app.sellerretailreports.entity;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class ReportSpecification {
    private ReportType reportType;
    private List<ReportOption> reportOptions;
    private LocalDate dataStartTime;
    private LocalDate dataEndTime;
    private List<String> marketplaceIds;

    public enum ReportType {
        GET_SALES_AND_TRAFFIC_REPORT
    }

    public enum ReportOption {
        DAY, PARENT
    }
}
