package com.study_partner.Study_Partner.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study_partner.Study_Partner.Util.AESUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvolvedPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String role;

    @Column(columnDefinition = "TEXT")
    private String encryptedDetails;

    @ManyToOne
    @JsonIgnore
    private RaggingReport report;

    public void setAdditionalDetails(String details) {
        try {
            this.encryptedDetails = AESUtil.encrypt(details);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    public String getAdditionalDetails() {
        try {
            return AESUtil.decrypt(encryptedDetails);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }

}
