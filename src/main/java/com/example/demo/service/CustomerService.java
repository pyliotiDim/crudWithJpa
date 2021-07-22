package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomer(Long customerId);
    Customer saveCustomer(Customer customer);
    String deleteCustomer(Long customerId);
    Customer updateCustomer(Customer customer);
}
