package com.app.sellerretailreports.service.report;

import com.app.sellerretailreports.dto.report.ReportResponseDto;
import com.app.sellerretailreports.mapper.ReportMapper;
import com.app.sellerretailreports.repository.report.ReportRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository repository;
    private final ReportMapper reportMapper;

    @Override
    public List<ReportResponseDto> findAll() {
        return repository.findAll().stream()
                .map(reportMapper::toDto)
                .toList();
    }
}
