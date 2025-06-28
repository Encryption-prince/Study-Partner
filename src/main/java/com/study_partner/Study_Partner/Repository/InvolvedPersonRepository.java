package com.study_partner.Study_Partner.Repository;

import com.study_partner.Study_Partner.Entity.InvolvedPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvolvedPersonRepository extends JpaRepository<InvolvedPerson, UUID> {
}
