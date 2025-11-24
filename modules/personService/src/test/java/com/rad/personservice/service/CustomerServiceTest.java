package com.rad.personservice.service;


import com.rad.personservice.model.entity.Customer;
import com.rad.personservice.model.entity.Job;
import com.rad.personservice.model.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void findAll_ShouldReturnAllCustomers() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(Job.builder().id(1L).companyName("company").build());
        jobs.add(Job.builder().id(2L).companyName("company2").build());
        Customer customer1 = new Customer("123456789",jobs);
        Customer customer2 = new Customer("123456789",jobs);

    }

}
