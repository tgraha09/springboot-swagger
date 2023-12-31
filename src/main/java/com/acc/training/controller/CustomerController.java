package com.acc.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.acc.training.customerapi.api.CustomerApi;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.service.CustomerService;

@RestController
public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerService service;

    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer body) {

        Customer response = service.createCustomer(body);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<Customer> getCustomer(String id) {

        //TODO - add logic to validate customer ID

        Customer response = service.getCustomer(id);

        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}