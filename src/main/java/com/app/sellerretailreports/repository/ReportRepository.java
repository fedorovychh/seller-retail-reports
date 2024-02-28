package com.app.sellerretailreports.repository;

import com.app.sellerretailreports.entity.SalesAndTrafficReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<SalesAndTrafficReport, String> {
}
