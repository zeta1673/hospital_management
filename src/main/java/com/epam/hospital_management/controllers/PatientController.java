package com.epam.hospital_management.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hospital_management.models.Patient;
import com.epam.hospital_management.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    private ArrayList<Patient> findAll() {
        return patientService.findAll();
    }

    @GetMapping("/{field}")
    private ArrayList<Patient> findAllSorted(@PathVariable String field) {
        return patientService.findAllSorted(field);
    }

    @PostMapping()
    private Patient create(@RequestBody Patient patient) {
        return patientService.create(patient);
    }
}
