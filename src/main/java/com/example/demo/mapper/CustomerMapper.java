package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto convertToDto(Customer customer){
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        return dto;
    }

    public static Customer convertToEntity(CustomerDto customerDto){

        Customer entity = new Customer();
        entity.setId(customerDto.getId());
        entity.setName(customerDto.getName());
        entity.setEmail(customerDto.getEmail());
        return entity;
    }
}
