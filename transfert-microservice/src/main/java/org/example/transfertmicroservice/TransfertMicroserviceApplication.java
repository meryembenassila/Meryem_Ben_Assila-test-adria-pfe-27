package org.example.transfertmicroservice;

import org.example.transfertmicroservice.entities.Transaction;
import org.example.transfertmicroservice.openfeign.BanckAccountRestClient;
import org.example.transfertmicroservice.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication

@EnableFeignClients
public class TransfertMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransfertMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository transactionRepository, BanckAccountRestClient banckAccountRestClient){
        return args -> {
             banckAccountRestClient.getBankaccounts().forEach(bankaccount -> {
                 Transaction transaction  = new Transaction();
                 transaction.setAmmount(Math.random()*100+10000);
                 transaction.setBankaccountid(bankaccount.getId());
                 transaction.setCreatedAt(new Date());
                 transaction.setMerchantCategory("MerchantCategory");
                 transaction.setCountry("Country");
               transaction.setCurrency("Currency");
               transactionRepository.save(transaction);
             });

        };
    }




}
