package org.example.accountservice.services;


import lombok.AllArgsConstructor;
import org.example.accountservice.entities.Bankaccount;
import org.example.accountservice.repositories.BanckAccountRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankaccountService  {
    BanckAccountRepository bankaccountRepository;


    public Bankaccount addbankaccount(Bankaccount bankaccount) {
        return bankaccountRepository.save(bankaccount);
    }


    public List<Bankaccount> getAllbankaccounts() {
        return bankaccountRepository.findAll();
    }


    public Bankaccount getBankaccount(String id) {
        return bankaccountRepository.findById(id).orElse(null);
    }

    public void deletebankaccount(String id) {
        bankaccountRepository.deleteById(id);
    }
}
