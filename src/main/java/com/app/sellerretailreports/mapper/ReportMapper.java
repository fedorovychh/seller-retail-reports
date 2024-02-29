package com.app.sellerretailreports.mapper;

import com.app.sellerretailreports.config.MapperConfig;
import com.app.sellerretailreports.dto.report.ReportResponseDto;
import com.app.sellerretailreports.entity.report.SalesAndTrafficReport;
import org.mapstruct.Mapper;

@Mapper(
        config = MapperConfig.class,
        uses = {
            ReportSpecificationMapper.class,
            SalesAndTrafficByDateMapper.class,
            SalesAndTrafficByAsinMapper.class
        }
)
public interface ReportMapper {
    ReportResponseDto toDto(SalesAndTrafficReport salesAndTrafficReport);
}
