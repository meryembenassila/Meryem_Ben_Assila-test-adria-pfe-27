package org.example.transfertmicroservice.controllers;



import lombok.AllArgsConstructor;
import org.example.transfertmicroservice.entities.Transaction;
import org.example.transfertmicroservice.openfeign.BanckAccountRestClient;
import org.example.transfertmicroservice.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor

public class TransactionController {
    TransactionService transactionService;
    BanckAccountRestClient banckAccountRestClient;

    @PostMapping("api/transactions")
    Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addtransaction(transaction);
    }

    @GetMapping("api/transactions")
    List<Transaction> getTransactions(){
        List<Transaction> transactions = transactionService.getAlltransactions();
        transactions.forEach(transaction -> {
            transaction.setBankaccount(banckAccountRestClient.getBankaccountById(transaction.getBankaccountid()));
        });
        return  transactions;
    }

    @GetMapping("api/transactions/{id}")
    Transaction getTransaction(@PathVariable String id ){
        Transaction transaction = transactionService.getTransaction(id);
        transaction.setBankaccount(banckAccountRestClient.getBankaccountById(transaction.getBankaccountid()));

        return  transaction;
    }

    @DeleteMapping("api/transactions/{id}")
    void deleteTransaction(@PathVariable String id){
        transactionService.deletetransaction(id);
    }
}

