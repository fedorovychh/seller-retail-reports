package com.app.sellerretailreports.mapper;

import com.app.sellerretailreports.config.MapperConfig;
import com.app.sellerretailreports.dto.report.SalesAndTrafficByDateDto;
import com.app.sellerretailreports.entity.report.SalesAndTrafficByDate;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SalesAndTrafficByDateMapper {
    SalesAndTrafficByDate toEntity(SalesAndTrafficByDateDto salesAndTrafficByDateDto);

    SalesAndTrafficByDateDto toDto(SalesAndTrafficByDate salesAndTrafficByDate);
}
