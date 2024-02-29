package com.app.sellerretailreports.cache;

import java.util.List;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

@Component
public class SpringCacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
    private static final String SALES_AND_TRAFFIC_BY_DATES_BETWEEN =
            "salesAndTrafficByDatesBetween";
    private static final String SALES_AND_TRAFFIC_BY_SPECIFIED_DATE =
            "salesAndTrafficBySpecifiedDate";
    private static final String SALES_AND_TRAFFIC_BY_SPECIFIED_ASINS =
            "salesAndTrafficBySpecifiedAsins";
    private static final String SALES_AND_TRAFFIC_BY_ASINS =
            "salesAndTrafficByAsins";
    private static final String SALES_AND_TRAFFIC_BY_DATES =
            "salesAndTrafficByDates";

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(List.of(
                SALES_AND_TRAFFIC_BY_DATES_BETWEEN,
                SALES_AND_TRAFFIC_BY_SPECIFIED_DATE,
                SALES_AND_TRAFFIC_BY_SPECIFIED_ASINS,
                SALES_AND_TRAFFIC_BY_ASINS,
                SALES_AND_TRAFFIC_BY_DATES
            )
        );
    }
}
