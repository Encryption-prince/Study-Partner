package com.study_partner.Study_Partner.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LostFoundItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String itemName;
    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String photoUrl; // image as string link

    private LocalDate reportedDate;

    @Enumerated(EnumType.STRING)
    private Status status; // LOST or FOUND or CLAIMED

    private String reporterContact; // optional (email/phone) for internal contact

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Status {
        LOST, FOUND, CLAIMED
    }
}