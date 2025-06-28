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
public class Witness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String encryptedContactInfo;
    private boolean isAnonymous;

    @ManyToOne
    @JsonIgnore
    private RaggingReport report;

    public void setContactInfo(String contactInfo) {
        try {
            this.encryptedContactInfo = AESUtil.encrypt(contactInfo);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    public String getContactInfo() {
        try {
            return AESUtil.decrypt(encryptedContactInfo);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }

}
