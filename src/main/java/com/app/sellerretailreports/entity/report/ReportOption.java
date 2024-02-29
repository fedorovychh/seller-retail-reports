package com.app.sellerretailreports.entity.report;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
public class ReportOption {
    @Field(targetType = FieldType.STRING)
    private Granularity dateGranularity;
    @Field(targetType = FieldType.STRING)
    private Granularity asinGranularity;

    public enum Granularity {
        DAY, PARENT
    }
}
