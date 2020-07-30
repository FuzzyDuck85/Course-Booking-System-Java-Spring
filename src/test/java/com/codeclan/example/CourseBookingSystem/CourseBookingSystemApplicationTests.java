package com.codeclan.example.CourseBookingSystem;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCustomerByTownAndCourse(){
		List<Customer> foundCustomers = customerRepository.findByTownAndBookingsCourseNameAllIgnoreCase("glasgow", "PyTHon");
		assertEquals("Niall", foundCustomers.get(0).getName());
	}

	@Test
	public void canGetCustomerByTownAndCourseAndAge(){
		List<Customer> foundCustomers = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseNameAllIgnoreCase(29,"Ayr", "Spring");
		assertEquals("Steve", foundCustomers.get(0).getName());
	}

}
