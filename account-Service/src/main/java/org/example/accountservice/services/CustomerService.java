package org.example.accountservice.services;


import lombok.AllArgsConstructor;
import org.example.accountservice.entities.Customer;
import org.example.accountservice.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService  {
    CustomerRepository customerRepository;

    
    public Customer addcustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    
    public List<Customer> getAllcustomers() {
        return customerRepository.findAll();
    }

    
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    
    public void deletecustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
