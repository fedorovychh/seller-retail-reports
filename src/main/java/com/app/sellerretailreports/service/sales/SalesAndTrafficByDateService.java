package com.app.sellerretailreports.service.sales;

import com.app.sellerretailreports.dto.report.SalesAndTrafficByAsinDto;
import com.app.sellerretailreports.dto.report.SalesAndTrafficByDateDto;
import java.time.LocalDate;
import java.util.List;

public interface SalesAndTrafficByDateService {
    List<SalesAndTrafficByDateDto> findAllBetweenDates(LocalDate start, LocalDate end);

    List<SalesAndTrafficByAsinDto> findAllByAsins();

    List<SalesAndTrafficByDateDto> findAllByDates();

    List<SalesAndTrafficByAsinDto> findAllBySpecifiedAsins(List<String> asins);
}
