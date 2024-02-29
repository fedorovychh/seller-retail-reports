package com.app.sellerretailreports.service.sales;

import com.app.sellerretailreports.dto.report.SalesAndTrafficByAsinDto;
import com.app.sellerretailreports.dto.report.SalesAndTrafficByDateDto;
import com.app.sellerretailreports.entity.report.SalesAndTrafficReport;
import com.app.sellerretailreports.mapper.SalesAndTrafficByAsinMapper;
import com.app.sellerretailreports.mapper.SalesAndTrafficByDateMapper;
import com.app.sellerretailreports.repository.report.ReportRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesAndTrafficByDateServiceImpl implements SalesAndTrafficByDateService {
    private final ReportRepository repository;
    private final SalesAndTrafficByDateMapper salesAndTrafficByDateMapper;
    private final SalesAndTrafficByAsinMapper salesAndTrafficByAsinMapper;

    @Override
    public List<SalesAndTrafficByDateDto> findAllBetweenDates(LocalDate start, LocalDate end) {
        SalesAndTrafficReport salesAndTrafficReport = repository.findAll().get(0);
        return salesAndTrafficReport.getSalesAndTrafficByDate().stream()
                .filter(s -> (s.getDate().isAfter(start) && s.getDate().isBefore(end))
                        || (s.getDate().equals(start) || s.getDate().equals(end)))
                .map(salesAndTrafficByDateMapper::toDto)
                .toList();
    }

    @Override
    public List<SalesAndTrafficByAsinDto> findAllBySpecifiedAsins(List<String> asins) {
        SalesAndTrafficReport salesAndTrafficReport = repository.findAll().get(0);
        return salesAndTrafficReport.getSalesAndTrafficByAsin().stream()
                .filter(s -> asins.contains(s.getParentAsin()))
                .map(salesAndTrafficByAsinMapper::toDto)
                .toList();
    }

    @Override
    public List<SalesAndTrafficByAsinDto> findAllByAsins() {
        SalesAndTrafficReport salesAndTrafficReport = repository.findAll().get(0);
        return salesAndTrafficReport.getSalesAndTrafficByAsin().stream()
                .map(salesAndTrafficByAsinMapper::toDto)
                .toList();
    }

    @Override
    public List<SalesAndTrafficByDateDto> findAllByDates() {
        SalesAndTrafficReport salesAndTrafficReport = repository.findAll().get(0);
        return salesAndTrafficReport.getSalesAndTrafficByDate().stream()
                .map(salesAndTrafficByDateMapper::toDto)
                .toList();
    }
}
