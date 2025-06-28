package com.study_partner.Study_Partner.Repository;

import com.study_partner.Study_Partner.Entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EvidenceRepository extends JpaRepository<Evidence, UUID> {
}
