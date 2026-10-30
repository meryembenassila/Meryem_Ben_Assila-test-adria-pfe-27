package org.example.accountservice.controllers;

import org.example.accountservice.entities.Bankaccount;
import org.example.accountservice.services.BankaccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BanckAccountController {
    BankaccountService bankaccountService;

    @PostMapping("api/bankaccounts")
    Bankaccount addBankaccount(@RequestBody Bankaccount bankaccount){
        return bankaccountService.addbankaccount(bankaccount);
    }

    @GetMapping("api/bankaccounts")
    List<Bankaccount> getBankaccounts(){
        return  bankaccountService.getAllbankaccounts();
    }

    @GetMapping("api/bankaccounts/{id}")
    Bankaccount getBankaccount(@PathVariable String. id ){
        return  bankaccountService.getBankaccount(id);
    }

    @DeleteMapping("api/bankaccounts/{id}")
    void deleteBankaccount(@PathVariable String id){
        bankaccountService.deletebankaccount(id);
    }
}
