package com.study_partner.Study_Partner.Repository;

import com.study_partner.Study_Partner.Entity.RaggingReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RaggingReportRepository extends JpaRepository<RaggingReport, UUID> {
}
