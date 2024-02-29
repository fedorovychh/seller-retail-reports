package com.app.sellerretailreports.service.updater;

import com.app.sellerretailreports.entity.report.SalesAndTrafficReport;
import com.app.sellerretailreports.repository.report.ReportRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportUpdaterServiceImpl implements ReportUpdaterService {
    private final ReportRepository repository;

    @Override
    public void updateDb() {
        SalesAndTrafficReport report = getReport();
        repository.save(report);
    }

    private SalesAndTrafficReport getReport() {
        String jsonString = FileReaderService.readFile("test_report.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(jsonString, SalesAndTrafficReport.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
