package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("Python", "Glasgow", 5);
        courseRepository.save(course1);

        Customer customer1 = new Customer("Niall", "Glasgow", 21);
        customerRepository.save(customer1);

        Booking booking1 = new Booking("4th May 2020", course1, customer1);
        bookingRepository.save(booking1);

//        customer1.addBookingToCustomer(booking1);
//        customerRepository.save(customer1);




        Course course2 = new Course("Spring", "Edinburgh", 3);
        courseRepository.save(course2);

        Customer customer2 = new Customer("Steve", "Ayr", 30);
        customerRepository.save(customer2);

        Booking booking2 = new Booking("19th June 2020", course2, customer2);
        bookingRepository.save(booking2);

//        customer2.addBookingToCustomer(booking2);
//        customerRepository.save(customer2);



        Booking booking3 = new Booking("19th June 2020", course1, customer2);
        bookingRepository.save(booking3);

//        customer2.addBookingToCustomer(booking3);
//        customerRepository.save(customer2);
    }
}
