package org.example.transfertmicroservice.services;



import lombok.AllArgsConstructor;


import org.example.transfertmicroservice.entities.Transaction;
import org.example.transfertmicroservice.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService  {

private TransactionRepository transactionRepository;

    public Transaction addtransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


    public List<Transaction> getAlltransactions() {
        return transactionRepository.findAll();
    }


    public Transaction getTransaction(String id) {
        return transactionRepository.findById(id).orElse(null);
    }


    public void deletetransaction(String id) {
        transactionRepository.deleteById(id);
    }
}
