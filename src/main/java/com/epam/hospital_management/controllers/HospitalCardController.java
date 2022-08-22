package com.epam.hospital_management.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hospital_management.models.HospitalCard;
import com.epam.hospital_management.services.HospitalCardService;

@RestController
@RequestMapping("/card")
public class HospitalCardController {

    @Autowired
    private HospitalCardService hospitalCardService;

    @GetMapping()
    private ArrayList<HospitalCard> findAll() {
        return hospitalCardService.findAll();
    }

    @PostMapping()
    private HospitalCard create(@RequestBody HospitalCard hospitalCard) {
        return hospitalCardService.create(hospitalCard);
    }
}
