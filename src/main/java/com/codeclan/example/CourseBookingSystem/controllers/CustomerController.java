package com.codeclan.example.CourseBookingSystem.controllers;


import com.codeclan.example.CourseBookingSystem.models.Customer;

import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findAllCustomers(
            @RequestParam (name = "town", required = false)String town,
            @RequestParam (name = "courseName", required = false) String courseName,
            @RequestParam (name = "age", required = false)Integer age
    ){
        if (age != null && town != null && courseName != null){
            List<Customer> foundCustomersAge = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseNameAllIgnoreCase(age, town, courseName);
            return new ResponseEntity<>(foundCustomersAge, HttpStatus.OK);
        }

        if (town != null && courseName != null){
            List<Customer> foundCustomers = customerRepository.findByTownAndBookingsCourseNameAllIgnoreCase(town, courseName);
            return new ResponseEntity<>(foundCustomers, HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomers(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/customers/bookings/courses")
    public ResponseEntity<List<Customer>> findCustomersByCourse(
            @RequestParam (name = "name", required = false) String name
    ){
        if (name != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
