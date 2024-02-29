package com.app.sellerretailreports.entity.report;

import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
public class SaleParams {
    private BigDecimal amount;
    @Field(targetType = FieldType.STRING)
    private CurrencyCode currencyCode;

    public enum CurrencyCode {
        USD
    }
}
