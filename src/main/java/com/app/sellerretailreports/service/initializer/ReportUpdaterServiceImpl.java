package com.app.sellerretailreports.service.initializer;

import com.app.sellerretailreports.entity.report.SalesAndTrafficReport;
import com.app.sellerretailreports.repository.report.ReportRepository;
import com.app.sellerretailreports.service.file.FileReaderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportUpdaterServiceImpl implements ReportInitializerService {
    private static final String INITIALIZE_JSON_PATH =
            "src\\main\\resources\\db\\json\\test_report.json";
    private static final String UPDATE_JSON_PATH =
            "src\\main\\resources\\db\\json\\db_report.json";
    private final ReportRepository repository;

    @Override
    @PostConstruct
    public void initialize() {
        SalesAndTrafficReport report = getReport(INITIALIZE_JSON_PATH);
        SalesAndTrafficReport saved = repository.save(report);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            objectMapper.writeValue(new File(UPDATE_JSON_PATH), saved);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        SalesAndTrafficReport report = getReport("src\\main\\resources\\db\\json\\db_report.json");
        repository.save(report);
    }

    private SalesAndTrafficReport getReport(String fileName) {
        String jsonString = FileReaderService.readFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(jsonString, SalesAndTrafficReport.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
