package com.app.sellerretailreports.controller;

import com.app.sellerretailreports.entity.Obj;
import com.app.sellerretailreports.entity.SalesAndTrafficReport;
import com.app.sellerretailreports.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HealthController {
    @GetMapping("/health")
    public String getHealth() {
        return "API working...";
    }
}
