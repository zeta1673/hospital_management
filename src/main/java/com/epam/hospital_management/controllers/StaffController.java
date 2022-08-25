package com.epam.hospital_management.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hospital_management.models.Staff;
import com.epam.hospital_management.services.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // @GetMapping()
    // private List<Staff> findAll() {
    // return staffService.findAll();
    // }

    @GetMapping("/{id}")
    private Optional<Staff> findById(@PathVariable Long id) {
        return staffService.findById(id);
    }

    @GetMapping()
    private Page<Staff> findAll(@RequestParam Optional<Integer> pageNumber,
            @RequestParam Optional<Integer> pageSize, @RequestParam Optional<String> sortBy,
            @RequestParam Optional<Direction> order) {

        return staffService
                .findAll(PageRequest.of(pageNumber.orElse(0), pageSize.orElse(5), order.orElse(Direction.ASC),
                        sortBy.orElse("id")));
    }

    @PostMapping()
    private Staff staffMember(@Valid @RequestBody Staff staffMember) {
        return staffService.create(staffMember);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            staffService.findById(id);
            staffService.deleteById(id);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("error deleting the data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("staff member deleted", HttpStatus.OK);
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

    // @GetMapping(params = "sortBy")
    // private ResponseEntity<List<Staff>> findAll(@RequestParam String
    // sortBy,@RequestParam int pageNumber,
    // @RequestParam int pageSize, @RequestParam String sortOrder) {

    // if (sortOrder.equals("asc")) {
    // Pageable pageable = PageRequest.of(pageNumber, pageSize,
    // Sort.by(sortBy).ascending());
    // return staffService.findAll(pageable);
    // } else if (sortOrder.equals("desc")) {
    // Pageable pageable = PageRequest.of(pageNumber, pageSize,
    // Sort.by(sortBy).descending());
    // return staffService.findAll(pageable);
    // } else{
    // return
    // }

    // }

    // @GetMapping(params = "sortBy")
    // private List<Staff> findAllSorted(@RequestParam(defaultValue = "name") String
    // sortBy) {

    // if (sortBy.equals("name")) {
    // return staffService.findAll()
    // .stream()
    // .sorted(Comparator.comparing(Staff::getName))
    // .collect(Collectors.toList());
    // } else if (sortBy.equals("lastName")) {
    // return staffService.findAll()
    // .stream()
    // .sorted(Comparator.comparing(Staff::getLastName))
    // .collect(Collectors.toList());
    // } else {
    // return staffService.findAll();
    // }
    // }
}
