package com.acc.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomer (String id){

        return repository.getCustomer(id);

    }

    public Customer createCustomer(Customer customer){

        return repository.saveCustomer(customer);
    }
}