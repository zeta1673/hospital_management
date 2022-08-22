package com.epam.hospital_management.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hospital_management.models.Staff;
import com.epam.hospital_management.services.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping()
    private ArrayList<Staff> findAll() {
        return staffService.findAll();
    }

    @GetMapping("/{field}")
    private ArrayList<Staff> findAllSorted(@PathVariable String field) {
        return staffService.findAllSorted(field);
    }

    @PostMapping()
    private Staff staffMember(@Valid @RequestBody Staff staffMember) {
        return staffService.create(staffMember);
    }

    // @PostMapping()
    // private ResponseEntity<?> create(@Valid @RequestBody Staff staffMember,
    // BindingResult result) {

    // Map<String, Object> response = new HashMap<>();

    // if (result.hasErrors()) {
    // List<String> errors = result.getFieldErrors()
    // .stream()
    // .map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
    // .collect(Collectors.toList());

    // response.put("errors", errors);
    // return new ResponseEntity<Map<String, Object>>(response,
    // HttpStatus.BAD_REQUEST);

    // } else {
    // try {
    // staffService.create(staffMember);
    // } catch (DataAccessException e) {
    // response.put("error", e.getMessage().concat(":
    // ").concat(e.getMostSpecificCause().getMessage()));
    // return new ResponseEntity<Map<String, Object>>(response,
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // response.put("mensaje", "El ha sido creado con éxito!");

    // return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    // }
    // }
}
