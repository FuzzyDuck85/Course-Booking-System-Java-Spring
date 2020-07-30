package com.codeclan.example.CourseBookingSystem.repositories;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByTownAndBookingsCourseNameAllIgnoreCase(String town, String name);

    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseNameAllIgnoreCase(Integer age, String town, String name);
}
