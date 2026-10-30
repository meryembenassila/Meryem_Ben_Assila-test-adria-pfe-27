package org.example.transfertmicroservice.controllers;



import lombok.AllArgsConstructor;
import org.example.transfertmicroservice.entities.Transaction;
import org.example.transfertmicroservice.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class TransactionController {
    TransactionService transactionService;

    @PostMapping("api/transactions")
    Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addtransaction(transaction);
    }

    @GetMapping("api/transactions")
    List<Transaction> getTransactions(){
        return  transactionService.getAlltransactions();
    }

    @GetMapping("api/transactions/{id}")
    Transaction getTransaction(@PathVariable String id ){
        return  transactionService.getTransaction(id);
    }

    @DeleteMapping("api/transactions/{id}")
    void deleteTransaction(@PathVariable String id){
        transactionService.deletetransaction(id);
    }
}

