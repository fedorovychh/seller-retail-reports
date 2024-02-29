package com.app.sellerretailreports.dto.report;

import com.app.sellerretailreports.entity.report.ReportOption;
import com.app.sellerretailreports.entity.report.ReportSpecification.ReportType;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
public class ReportSpecificationDto {
    @Field(targetType = FieldType.STRING)
    private ReportType reportType;
    private ReportOption reportOptions;
    private LocalDate dataStartTime;
    private LocalDate dataEndTime;
    private List<String> marketplaceIds;
}
