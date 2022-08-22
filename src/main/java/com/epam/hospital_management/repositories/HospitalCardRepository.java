package com.epam.hospital_management.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.hospital_management.models.HospitalCard;

public interface HospitalCardRepository extends CrudRepository<HospitalCard, Long> {

}
