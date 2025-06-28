package com.study_partner.Study_Partner.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaggingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate dateOfIncident;
    private LocalTime timeOfIncident;
    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean reportAsSelf;
    private String status = "PENDING";

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;  // <-- ✅ add this line

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<InvolvedPerson> involvedPersons;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<Witness> witnesses;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<Evidence> evidences;

    private String severityLevel;

}

