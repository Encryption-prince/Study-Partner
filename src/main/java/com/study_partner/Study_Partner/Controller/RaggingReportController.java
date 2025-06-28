package com.study_partner.Study_Partner.Controller;

import com.study_partner.Study_Partner.Dto.RaggingReportRequest;
import com.study_partner.Study_Partner.Entity.RaggingReport;
import com.study_partner.Study_Partner.Service.RaggingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/ragging-reports")
@CrossOrigin(origins = "*")
public class RaggingReportController {

    @Autowired
    private RaggingReportService reportService;

    @PostMapping
    public ResponseEntity<?> submitReport(@RequestBody RaggingReportRequest request) {
        RaggingReport saved = reportService.createReport(request);
        return ResponseEntity.ok(Map.of("reportId", saved.getId(), "status", saved.getStatus()));
    }

    @GetMapping
    public ResponseEntity<?> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getReportById(@PathVariable UUID id) {
        Optional<RaggingReport> optionalReport = reportService.getReportById(id);
        if (optionalReport.isPresent()) {
            return ResponseEntity.ok(optionalReport.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Report not found"));
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateReportStatus(@PathVariable UUID id, @RequestParam String newStatus) {
        try {
            RaggingReport updatedReport = reportService.updateReportStatus(id, newStatus);
            return ResponseEntity.ok(Map.of("message", "Status updated", "reportId", updatedReport.getId()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", e.getMessage()));
        }
    }


}
