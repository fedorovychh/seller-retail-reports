package com.app.sellerretailreports.controller;

import com.app.sellerretailreports.dto.report.ReportResponseDto;
import com.app.sellerretailreports.service.report.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Report management",
        description = "Endpoints for getting reports.")
public class ReportController {
    private final ReportService reportService;

    @GetMapping(value = "/reports")
    @Operation(summary = "Get reports by all dates")
    public List<ReportResponseDto> getAll() {
        return reportService.findAll();
    }
}
