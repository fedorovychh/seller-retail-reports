package com.app.sellerretailreports.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalesByDate {
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int unitsOrdered;
    private int getUnitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private AverageSalesPerOrderItem averageSalesPerOrderItem;
    private AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
    private BigDecimal averageUnitsPerOrderItem;
    private BigDecimal averageUnitsPerOrderItemB2B;
    private AverageSellingPrice averageSellingPrice;
    private AverageSellingPriceB2B averageSellingPriceB2B;
    private int unitsRefunded;
    private BigDecimal refundRate;
    private int claimsGranted;
    private ShippedProductSales shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;
}
