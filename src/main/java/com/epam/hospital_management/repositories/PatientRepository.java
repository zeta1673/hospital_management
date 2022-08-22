package com.epam.hospital_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.hospital_management.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
