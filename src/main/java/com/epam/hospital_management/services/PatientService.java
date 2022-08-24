package com.epam.hospital_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hospital_management.models.Patient;
import com.epam.hospital_management.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

}
