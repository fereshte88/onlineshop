package com.rad.personservice.service;



import com.rad.personservice.exception.ResourceNotFoundException;
import com.rad.personservice.model.dto.CustomerDto;
import com.rad.personservice.model.entity.Customer;
import com.rad.personservice.model.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Optional<Customer> findById(long id) {
       return Optional.ofNullable(customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id)));
    }

    public List<Customer> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.isEmpty() ? new ArrayList<>() : customerList;
    }

    public Customer save(CustomerDto customerDto) {
        Customer customer = Customer.builder().firstName(customerDto.getFirstName())
                                                    .lastName(customerDto.getLastName())
                                                    .nationalCode(customerDto.getNationalCode())
                                                    .jobs(customerDto.getJobs())
                                                    .createAt(new Date(System.currentTimeMillis()))
                                                    .build();
        return customerRepository.save(customer);
    }

    public Customer update(CustomerDto customerDto,Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            Customer editedCustomer = customer.get();
            if (customerDto.getFirstName() != null) {
                editedCustomer.setFirstName(customerDto.getFirstName());
            }
            if (customerDto.getLastName() != null) {
                editedCustomer.setLastName(customerDto.getLastName());
            }
            if (customerDto.getNationalCode() != null) {
                editedCustomer.setNationalCode(customerDto.getNationalCode());
            }
//            if (personADto.getJobs() != null) {
//                editPersonA.setJobs(personADto.getJobs());
//            }
            editedCustomer.setUpdateAt(new Date(System.currentTimeMillis()));
            customerRepository.save(editedCustomer);
            return editedCustomer;
        } else {
            throw new RuntimeException("Teacher with id" + id + "not found.");
        }

    }
    public Customer deleteById(long id) {
        Customer customer = this.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
        customerRepository.deleteById(id);
       return customer;
    }

}
