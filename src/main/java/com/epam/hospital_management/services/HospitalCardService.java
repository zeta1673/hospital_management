package com.epam.hospital_management.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hospital_management.models.HospitalCard;
import com.epam.hospital_management.repositories.HospitalCardRepository;

@Service
public class HospitalCardService {

    @Autowired
    private HospitalCardRepository hospitalCardRepository;

    public ArrayList<HospitalCard> findAll() {
        return (ArrayList<HospitalCard>) hospitalCardRepository.findAll();
    }

    public HospitalCard create(HospitalCard hospitalCard){
        return hospitalCardRepository.save(hospitalCard);
    }
}
