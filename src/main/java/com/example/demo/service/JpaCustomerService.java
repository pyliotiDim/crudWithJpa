package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaCustomerService implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public JpaCustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId){
        return customerRepository.findById(customerId)
                .orElse(null);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public String deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
        return "customer removed !! "+ customerId;
    }

    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist."));
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setCity(customer.getCity());
        return customerRepository.save(existingCustomer);
    }

}
