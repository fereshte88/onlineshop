package com.rad.personservice.controller;



import com.rad.personservice.model.dto.CustomerDto;
import com.rad.personservice.model.dto.apiResponse.GenericResponse;
import com.rad.personservice.model.entity.Customer;
import com.rad.personservice.service.CustomerService;
import com.rad.personservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<GenericResponse<Customer>> createCustomer(@RequestBody CustomerDto CustomerDto){

        try {
            customerService.save(CustomerDto);
            GenericResponse<Customer> genericResponse = GenericResponse.<Customer>success("Successfully Created");
            return ResponseEntity.status(HttpStatus.OK).body(genericResponse);

        } catch (Exception ex) {
            GenericResponse<Customer> genericResponse = GenericResponse.<Customer>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<GenericResponse<Customer>> getAllCustomer(){

        try {
            List<Customer> CustomerList = customerService.findAll();
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>builder().listData(CustomerList).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);

        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GenericResponse<Customer>> getCustomerById(@PathVariable long id){

        try {
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>builder().data(customerService.findById(id).orElse(null)).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);

        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<GenericResponse<Customer>> updateCustomer(@RequestBody CustomerDto CustomerDto, @PathVariable long id){

        try {
            customerService.update(CustomerDto,id);
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>success("Successfully Created");
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse<Customer>> deleteCustomerById(@PathVariable long id){
        try {
            customerService.deleteById(id);
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>success("Successfully Created");
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<Customer> apiResponse = GenericResponse.<Customer>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

}
