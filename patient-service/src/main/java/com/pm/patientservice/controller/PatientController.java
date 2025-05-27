package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name="Patient", description = "API for managing patients")
public class PatientController {
    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "get all the patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "create patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patient){
        PatientResponseDTO p = patientService.createPatient(patient);
        return p != null ? ResponseEntity.ok().body(p) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "edit patient")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id , @Valid @RequestBody PatientRequestDTO patient ){
        PatientResponseDTO p = patientService.updatePatient(id, patient);
        return p != null ? ResponseEntity.ok().body(p) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id ){
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
