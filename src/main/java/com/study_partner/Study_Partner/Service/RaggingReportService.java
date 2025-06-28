package com.study_partner.Study_Partner.Service;

import com.study_partner.Study_Partner.Dto.RaggingReportRequest;
import com.study_partner.Study_Partner.Entity.Evidence;
import com.study_partner.Study_Partner.Entity.InvolvedPerson;
import com.study_partner.Study_Partner.Entity.RaggingReport;
import com.study_partner.Study_Partner.Entity.Witness;
import com.study_partner.Study_Partner.Repository.EvidenceRepository;
import com.study_partner.Study_Partner.Repository.RaggingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RaggingReportService {

    @Autowired
    private RaggingReportRepository reportRepo;
    @Autowired
    private EvidenceRepository evidenceRepo;

    public RaggingReport createReport(RaggingReportRequest request) {

        RaggingReport report = new RaggingReport();
        report.setDateOfIncident(LocalDate.parse(request.getDateOfIncident()));
        report.setTimeOfIncident(LocalTime.parse(request.getTimeOfIncident()));
        report.setLocation(request.getLocation());
        report.setSeverityLevel(request.getSeverityLevel());
        report.setDescription(request.getDescription());
        report.setReportAsSelf(request.isReportAsSelf());
        report.setStatus(request.getStatus());

        List<InvolvedPerson> persons = new ArrayList<>();
        for (RaggingReportRequest.InvolvedPersonDTO dto : request.getInvolvedPersons()) {
            InvolvedPerson p = new InvolvedPerson();
            p.setName(dto.getName());
            p.setRole(dto.getRole());
            p.setAdditionalDetails(dto.getAdditionalDetails());
            p.setReport(report);
            persons.add(p);
        }
        report.setInvolvedPersons(persons);

        List<Witness> witnessList = new ArrayList<>();
        for (RaggingReportRequest.WitnessDTO dto : request.getWitnesses()) {
            Witness w = new Witness();
            w.setName(dto.getName());
            w.setContactInfo(dto.getContactInfo());
            w.setAnonymous(dto.isAnonymous());
            w.setReport(report);
            witnessList.add(w);
        }
        report.setWitnesses(witnessList);

        List<Evidence> evidenceList = request.getEvidences().stream().map(url -> {
            Evidence e = new Evidence();
            e.setFileUrl(url);
            e.setReport(report);
            return e;
        }).collect(Collectors.toList());
        report.setEvidences(evidenceList);

        return reportRepo.save(report);
    }

    public Optional<RaggingReport> getReportById(UUID id) {
        return reportRepo.findById(id);
    }

    public RaggingReport updateReportStatus(UUID id, String newStatus) {
        RaggingReport report = reportRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setStatus(newStatus);
        report.setUpdatedAt(LocalDateTime.now());
        return reportRepo.save(report);
    }

    public List<RaggingReport> getAllReports() {
        return reportRepo.findAll();
    }



}