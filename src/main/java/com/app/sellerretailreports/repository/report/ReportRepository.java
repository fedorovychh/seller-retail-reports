package com.app.sellerretailreports.repository.report;

import com.app.sellerretailreports.entity.report.SalesAndTrafficReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends MongoRepository<SalesAndTrafficReport, String> {
}
