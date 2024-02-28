package com.app.sellerretailreports.controller;

import com.app.sellerretailreports.dto.report.SalesAndTrafficByDateDto;
import com.app.sellerretailreports.service.sales.SalesAndTrafficByDateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sales")
@Tag(name = "Sales management",
        description = "Endpoints for managing sales.")
public class SalesAndTrafficByDateController {
    private final SalesAndTrafficByDateService salesAndTrafficByDateService;

    @GetMapping(value = "/all-by-date")
    @Operation(summary = "Get statistics for all dates")
    public SalesAndTrafficByDateDto getAll() {
        return salesAndTrafficByDateService.findAll();
    }
}
