package com.study_partner.Study_Partner.Controller;

import com.study_partner.Study_Partner.Entity.StudyMaterial;
import com.study_partner.Study_Partner.Service.StudyMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/study-materials")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudyMaterialController {

    private final StudyMaterialService service;

    @PostMapping
    public ResponseEntity<?> uploadMaterial(@RequestBody StudyMaterial material) {
        StudyMaterial saved = service.uploadMaterial(material);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<?> getAllMaterials() {
        return ResponseEntity.ok(service.getAllMaterials());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getMaterialById(@PathVariable UUID id) {
//        return service.getMaterialById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Material not found."));
//    }
@GetMapping("/{id}")
public ResponseEntity<StudyMaterial> getMaterialById(@PathVariable UUID id) {
    StudyMaterial material = service.getMaterialById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Material not found."));
    return ResponseEntity.ok(material);
}



    @GetMapping("/subject/{subject}")
    public ResponseEntity<?> getBySubject(@PathVariable String subject) {
        return ResponseEntity.ok(service.getMaterialsBySubject(subject));
    }

    @GetMapping("/semester/{semester}")
    public ResponseEntity<?> getBySemester(@PathVariable String semester) {
        return ResponseEntity.ok(service.getMaterialsBySemester(semester));
    }
}

