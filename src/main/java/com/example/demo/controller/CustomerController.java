package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper){
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<CustomerDto> findAllCustomers(){
        return customerService.getAllCustomers().stream().
                map(customerMapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{customerId}")
    public CustomerDto findCustomerById(@PathVariable Long customerId){
        return customerMapper.convertToDto(customerService.getCustomer(customerId));
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        customer.setId(customerId);
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId){
        return customerService.deleteCustomer(customerId);
    }

}
