package com.app.sellerretailreports.mapper;

import com.app.sellerretailreports.config.MapperConfig;
import com.app.sellerretailreports.dto.report.SalesAndTrafficByAsinDto;
import com.app.sellerretailreports.entity.report.SalesAndTrafficByAsin;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SalesAndTrafficByAsinMapper {
    SalesAndTrafficByAsin toEntity(SalesAndTrafficByAsinDto salesAndTrafficByAsinDto);

    SalesAndTrafficByAsinDto toDto(SalesAndTrafficByAsin salesAndTrafficByAsin);
}
