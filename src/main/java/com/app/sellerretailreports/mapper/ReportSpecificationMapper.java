package com.app.sellerretailreports.mapper;

import com.app.sellerretailreports.config.MapperConfig;
import com.app.sellerretailreports.dto.report.ReportSpecificationDto;
import com.app.sellerretailreports.entity.report.ReportSpecification;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ReportSpecificationMapper {
    ReportSpecification toEntity(ReportSpecificationDto reportSpecificationDto);

    ReportSpecificationDto toDto(ReportSpecification reportSpecification);
}
