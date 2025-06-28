package com.study_partner.Study_Partner.Repository;

import com.study_partner.Study_Partner.Entity.Witness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WitnessRepository extends JpaRepository<Witness, UUID> {
}
