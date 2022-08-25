package com.epam.hospital_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epam.hospital_management.models.Staff;
import com.epam.hospital_management.repositories.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    public Page<Staff> findAll(Pageable pageable) {
        return (Page<Staff>) staffRepository.findAll();
    }

    // public List<Staff> findAllSorted(String field) {
    // return (ArrayList<Staff>) staffRepository.findAll(Sort.by(Sort.Direction.ASC,
    // field));
    // }

    public Staff create(Staff staffMember) {
        return staffRepository.save(staffMember);
    }
}
