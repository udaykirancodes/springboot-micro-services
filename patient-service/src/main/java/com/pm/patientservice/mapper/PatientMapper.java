package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId().toString());
        dto.setName(patient.getName());
        dto.setAddress(patient.getAddress());
        dto.setDateOfBirth(patient.getDateOfBirth().toString());
        dto.setEmail(patient.getEmail());
        return dto;
    }
    public static Patient toModel(PatientRequestDTO dto) {
        Patient p = new Patient();
        p.setName(dto.getName());
        p.setAddress(dto.getAddress());
        p.setEmail(dto.getEmail());
        if(dto.getDateOfBirth() != null) {
            p.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        }
        if(dto.getDateOfBirth() != null) {
            p.setRegisteredDate(LocalDate.parse(dto.getRegisteredDate()));
        }
        return p;
    }
}
