package com.study_partner.Study_Partner.Service;

import com.study_partner.Study_Partner.Entity.StudyMaterial;
import com.study_partner.Study_Partner.Repository.StudyMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudyMaterialService {

    private final StudyMaterialRepository repository;

    public StudyMaterial uploadMaterial(StudyMaterial material) {
        return repository.save(material);
    }

    public List<StudyMaterial> getAllMaterials() {
        return repository.findAll();
    }

    public Optional<StudyMaterial> getMaterialById(UUID id) {
        return repository.findById(id);
    }

    public List<StudyMaterial> getMaterialsBySubject(String subject) {
        return repository.findBySubject(subject);
    }

    public List<StudyMaterial> getMaterialsBySemester(String semester) {
        return repository.findBySemester(semester);
    }
}

