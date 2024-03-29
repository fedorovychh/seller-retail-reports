package com.app.sellerretailreports.entity.report;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
public class ReportSpecification {
    @Field(targetType = FieldType.STRING)
    private ReportType reportType;
    private ReportOption reportOptions;
    private LocalDate dataStartTime;
    private LocalDate dataEndTime;
    private List<String> marketplaceIds;

    public enum ReportType {
        GET_SALES_AND_TRAFFIC_REPORT
    }
}
