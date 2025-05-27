package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotNull(message = "Name is required")
    @Size(max = 100 , message = "Name can not exceed 100 characters")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Date of birth is required")
    private String dateOfBirth;

    @NotNull(message = "Registered date is required")
    private String registeredDate;
}

