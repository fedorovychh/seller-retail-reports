package com.app.sellerretailreports.controller;

import com.app.sellerretailreports.service.initializer.ReportInitializerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Health Check", description = "Endpoint to check API")
public class HealthController {
    private final ReportInitializerService reportUpdaterService;

    @GetMapping("/health")
    @Operation(summary = "Check Health")
    public String getHealth() {
        return "API is running...";
    }

    @GetMapping("/update")
    public void updateDb() {
        reportUpdaterService.update();
    }
}
