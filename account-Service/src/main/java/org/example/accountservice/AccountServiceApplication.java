package org.example.accountservice;

import org.example.accountservice.entities.Bankaccount;
import org.example.accountservice.entities.Customer;
import org.example.accountservice.enums.StatusBackAccount;
import org.example.accountservice.repositories.BanckAccountRepository;
import org.example.accountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, BanckAccountRepository banckAccountRepository){
        return args -> {
            List<String> names = List.of("Ahmed", "Youssef", "Rayan");
            names.forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 3; i++) {
                    Bankaccount bankaccount = new Bankaccount();
                    bankaccount.setBalance(Math.random()*1000+1000);
                    bankaccount.setCurrency("Currency");
                    bankaccount.setStatusBackAccount(Math.random()<0.5? StatusBackAccount.ACTIVE:StatusBackAccount.BLOCKED);
                    bankaccount.setCustomer(customer);
                    banckAccountRepository.save(bankaccount);
                }

            });

        };
    }


}
