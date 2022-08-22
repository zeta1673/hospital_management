package com.epam.hospital_management.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.epam.hospital_management.models.Staff;
import com.epam.hospital_management.repositories.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public ArrayList<Staff> findAll() {
        return (ArrayList<Staff>) staffRepository.findAll();
    }

    public ArrayList<Staff> findAllSorted(String field) {
        return (ArrayList<Staff>) staffRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    // public ArrayList<Staff> findAllSorted() {
    // return staffRepository.findAllSorted();
    // }

    public Staff create(Staff staffMember) {
        return staffRepository.save(staffMember);
    }
}
