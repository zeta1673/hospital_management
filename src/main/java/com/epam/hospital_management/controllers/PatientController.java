package com.epam.hospital_management.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(params = "sortBy")
    private List<Patient> findAllSorted(@RequestParam(defaultValue = "name") String sort) {

        if (sort.equals("name")) {
            return patientService.findAll()
                    .stream()
                    .sorted(Comparator.comparing(Patient::getName))
                    .collect(Collectors.toList());
        } else if (sort.equals("lastName")) {
            return patientService.findAll()
                    .stream()
                    .sorted(Comparator.comparing(Patient::getLastName))
                    .collect(Collectors.toList());
        } else if (sort.equals("birthDate")) {
            return patientService.findAll()
                    .stream()
                    .sorted(Comparator.comparing(Patient::getBirthDate))
                    .collect(Collectors.toList());
        } else {
            return patientService.findAll();
        }

    }

    @PostMapping()
    private Patient create(@RequestBody Patient patient) {
        return patientService.create(patient);
    }
}
