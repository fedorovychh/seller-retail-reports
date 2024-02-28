package com.app.sellerretailreports.entity;

public class ReportOption {
    private Granularity dateGranularity;
    private Granularity asinGranularity;

    public enum Granularity {
        DAY, PARENT
    }
}
