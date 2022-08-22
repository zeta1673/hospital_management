package com.epam.hospital_management.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.epam.hospital_management.models.Patient;
import com.epam.hospital_management.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public ArrayList<Patient> findAll() {
        return (ArrayList<Patient>) patientRepository.findAll();
    }

    public ArrayList<Patient> findAllSorted(String field) {
        return (ArrayList<Patient>) patientRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

}
