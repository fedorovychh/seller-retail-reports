package com.app.sellerretailreports.dto.report;

import java.util.List;
import lombok.Data;

@Data
public class ReportResponseDto {
    private String id;
    private ReportSpecificationDto reportSpecification;
    private List<SalesAndTrafficByDateDto> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsinDto> salesAndTrafficByAsin;
}
