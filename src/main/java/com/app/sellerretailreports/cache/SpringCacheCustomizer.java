package com.app.sellerretailreports.cache;

import java.util.List;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

@Component
public class SpringCacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(List.of(
                "salesAndTrafficByDatesBetween",
                "salesAndTrafficBySpecifiedDate",
                "salesAndTrafficBySpecifiedAsins",
                "salesAndTrafficByAsins",
                "salesAndTrafficByDates"
            )
        );
    }
}
