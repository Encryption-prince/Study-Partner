package com.study_partner.Study_Partner.Repository;

import com.study_partner.Study_Partner.Entity.StudyMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudyMaterialRepository extends JpaRepository<StudyMaterial, UUID> {
    List<StudyMaterial> findBySubject(String subject);
    List<StudyMaterial> findBySemester(String semester);
}
