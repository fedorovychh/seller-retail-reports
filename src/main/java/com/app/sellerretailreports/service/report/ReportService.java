package com.app.sellerretailreports.service.report;

import com.app.sellerretailreports.dto.report.ReportResponseDto;
import java.util.List;

public interface ReportService {
    List<ReportResponseDto> findAll();
}
