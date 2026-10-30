package org.example.accountservice.controllers;

import org.example.accountservice.entities.Customer;
import org.example.accountservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {
    CustomerService customerService;

    @PostMapping("api/customers")
    Customer addCustomer(@RequestBody Customer customer){
        return customerService.addcustomer(customer);
    }

    @GetMapping("api/customers")
    List<Customer> getCustomers(){
        return  customerService.getAllcustomers();
    }

    @GetMapping("api/customers/{id}")
    Customer getCustomer(@PathVariable Long id ){
        return  customerService.getCustomer(id);
    }

    @DeleteMapping("api/customers/{id}")
    void deleteCustomer(@PathVariable Long id){
        customerService.deletecustomer(id);
    }
}
