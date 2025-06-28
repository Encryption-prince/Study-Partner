package com.study_partner.Study_Partner.Dto;

import lombok.Data;

import java.util.List;

@Data
public class RaggingReportRequest {

    private String dateOfIncident;
    private String timeOfIncident;
    private String location;
    private String severityLevel;
    private String description;
    private boolean reportAsSelf;
    private String status; // "DRAFT" or "PENDING"

    private List<InvolvedPersonDTO> involvedPersons;
    private List<WitnessDTO> witnesses;
    private List<String> evidences;

    @Data
    public static class InvolvedPersonDTO {
        private String name;
        private String role;
        private String additionalDetails;
    }

    @Data
    public static class WitnessDTO {
        private String name;
        private String contactInfo;
        private boolean isAnonymous;
    }
}

