package com.epam.hospital_management.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "staff")
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 30, message = "name need to have between 3 and 30 carachters.")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Speciality speciality;

}
