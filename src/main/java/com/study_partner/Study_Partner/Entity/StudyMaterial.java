package com.study_partner.Study_Partner.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudyMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String url;               // Link to the document (Google Drive / S3 / etc.)
    private String subject;
    private String semester;
    private String fileType;

    private double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime uploadedAt = LocalDateTime.now();

}