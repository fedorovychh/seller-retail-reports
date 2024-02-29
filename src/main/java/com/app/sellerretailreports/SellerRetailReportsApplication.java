package com.app.sellerretailreports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SellerRetailReportsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellerRetailReportsApplication.class, args);
    }
}
