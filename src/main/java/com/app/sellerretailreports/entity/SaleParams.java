package com.app.sellerretailreports.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleParams {
    private BigDecimal amount;
    private CurrencyCode currencyCode;

    public enum CurrencyCode {
        USD
    }
}
