package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class JpaCustomerServiceTest {

    private JpaCustomerService service;
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup(){
        customerRepository = mock(CustomerRepository.class);
        service = new JpaCustomerService(customerRepository);    }

    @Test
    public void testGetAllCustomer(){
        // given
        List<Customer> customers = Collections.singletonList(new Customer());
        when(customerRepository.findAll()).thenReturn(customers);

        // when
        List<Customer> result = service.getAllCustomers();

        // then
        Assertions.assertEquals(customers, result);
    }

    @Test
    public void testGetCustomer(){
        //given
        Customer customer = new Customer();
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(customer));

        //when
        Customer result = service.getCustomer(customerId);

        //then
        Assertions.assertEquals(customer, result);
    }

    @Test
    public void testSaveCustomer(){
        //given
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        //when
        Customer result = service.saveCustomer(customer);

        //then
        Assertions.assertEquals(customer, result);
    }

    @Test
    public void testDeleteCustomer(){
        //given
        Long customerId = 1L;

        //when
        service.deleteCustomer(customerId);

        //then
        verify(customerRepository, times(1)).deleteById(customerId);
    }

}
