package com.app.sellerretailreports.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

@Data
public class SaleParams {
    private BigDecimal amount;
    @Field(targetType = FieldType.STRING)
    private CurrencyCode currencyCode;

    public enum CurrencyCode {
        USD
    }
}
