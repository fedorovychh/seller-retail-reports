package com.app.sellerretailreports.controller;

import com.app.sellerretailreports.dto.report.SalesAndTrafficByAsinDto;
import com.app.sellerretailreports.dto.report.SalesAndTrafficByDateDto;
import com.app.sellerretailreports.entity.report.SalesAndTrafficByAsin;
import com.app.sellerretailreports.service.sales.SalesAndTrafficByDateService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sales")
@Tag(name = "Sales management",
        description = "Endpoints for managing sales.")
public class SalesAndTrafficController {
    private final SalesAndTrafficByDateService salesAndTrafficByDateService;

    @GetMapping(value = "/all-between-dates")
    @Operation(summary = "Get statistics between specified dates.")
    public List<SalesAndTrafficByDateDto> getAllBetweenDates(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return salesAndTrafficByDateService.findAllBetweenDates(start, end);
    }

    @GetMapping(value = "/all-by-specified-asins")
    @Operation(summary = "Get statistics by all specified asins.")
    public List<SalesAndTrafficByAsinDto> getAllByAsins(@RequestParam("asins") List<String> asins) {
        return salesAndTrafficByDateService.findAllBySpecifiedAsins(asins);
    }

    @GetMapping(value = "/all-by-dates")
    @Operation(summary = "Get statistics by all dates.")
    public List<SalesAndTrafficByDateDto> getAllByDates() {
        return salesAndTrafficByDateService.findAllByDates();
    }

    @GetMapping(value = "/all-by-asins")
    @Operation(summary = "Get statistics by all asins.")
    public List<SalesAndTrafficByAsinDto> getAllByAsins() {
        return salesAndTrafficByDateService.findAllByAsins();
    }
}
