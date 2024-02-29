package com.app.sellerretailreports.service.sales;

import com.app.sellerretailreports.dto.report.SalesAndTrafficByAsinDto;
import com.app.sellerretailreports.dto.report.SalesAndTrafficByDateDto;
import com.app.sellerretailreports.entity.report.SalesAndTrafficByDate;
import com.app.sellerretailreports.entity.report.SalesAndTrafficReport;
import com.app.sellerretailreports.mapper.SalesAndTrafficByAsinMapper;
import com.app.sellerretailreports.mapper.SalesAndTrafficByDateMapper;
import com.app.sellerretailreports.repository.report.ReportRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesAndTrafficByDateServiceImpl implements SalesAndTrafficByDateService {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final ReportRepository repository;
    private final SalesAndTrafficByDateMapper salesAndTrafficByDateMapper;
    private final SalesAndTrafficByAsinMapper salesAndTrafficByAsinMapper;

    @Override
    @Cacheable("salesAndTrafficByDatesBetween")
    public List<SalesAndTrafficByDateDto> findAllBetweenDates(LocalDate start, LocalDate end) {
        SalesAndTrafficReport salesAndTrafficReport = findReport();
        return salesAndTrafficReport.getSalesAndTrafficByDate().stream()
                .filter(s -> (s.getDate().isAfter(start) && s.getDate().isBefore(end))
                        || (s.getDate().equals(start) || s.getDate().equals(end)))
                .map(salesAndTrafficByDateMapper::toDto)
                .toList();
    }

    @Override
    @Cacheable("salesAndTrafficBySpecifiedDate")
    public SalesAndTrafficByDateDto findBySpecifiedDate(LocalDate localDate) {
        SalesAndTrafficReport salesAndTrafficReport = findReport();
        SalesAndTrafficByDate salesAndTrafficByDate = salesAndTrafficReport
                .getSalesAndTrafficByDate().stream()
                .filter(s -> s.getDate().isEqual(localDate))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Can't find sales in traffic by " + localDate)
                );
        return salesAndTrafficByDateMapper.toDto(salesAndTrafficByDate);
    }

    @Override
    @Cacheable("salesAndTrafficBySpecifiedAsins")
    public List<SalesAndTrafficByAsinDto> findAllBySpecifiedAsins(List<String> asins) {
        SalesAndTrafficReport salesAndTrafficReport = findReport();
        return salesAndTrafficReport.getSalesAndTrafficByAsin().stream()
                .filter(s -> asins.contains(s.getParentAsin()))
                .map(salesAndTrafficByAsinMapper::toDto)
                .toList();
    }

    @Override
    @Cacheable("salesAndTrafficByAsins")
    public List<SalesAndTrafficByAsinDto> findAllByAsins() {
        SalesAndTrafficReport salesAndTrafficReport = findReport();
        return salesAndTrafficReport.getSalesAndTrafficByAsin().stream()
                .map(salesAndTrafficByAsinMapper::toDto)
                .toList();
    }

    @Override
    @Cacheable("salesAndTrafficByDates")
    public List<SalesAndTrafficByDateDto> findAllByDates() {
        SalesAndTrafficReport salesAndTrafficReport = findReport();
        return salesAndTrafficReport.getSalesAndTrafficByDate().stream()
                .map(salesAndTrafficByDateMapper::toDto)
                .toList();
    }

    @CacheEvict(
            value = {
                    "salesAndTrafficByDatesBetween",
                    "salesAndTrafficBySpecifiedDate",
                    "salesAndTrafficBySpecifiedAsins",
                    "salesAndTrafficByAsins",
                    "salesAndTrafficByDates"
            },
            allEntries = true
    )
    @Scheduled(fixedRateString = "${caching.spring.TTL}")
    public void emptyHotelsCache() {
    }

    private SalesAndTrafficReport findReport() {
        return repository.findAll().get(FIRST_ELEMENT_INDEX);
    }
}
