package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> findAllCoursesByFilter(
            @RequestParam(name = "rating", required = false) Integer rating
    ){
        if (rating != null){
            ResponseEntity foundRating =  new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
            if(foundRating.hasBody()){
                return foundRating;
            }
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourses(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping(value ="/courses/bookings/customers")
    public ResponseEntity<List<Course>> findCoursesByBookingsCustomerId(
            @RequestParam (name = "id", required = false) Long id
    ){
        if (id != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}
