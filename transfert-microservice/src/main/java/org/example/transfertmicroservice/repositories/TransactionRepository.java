package org.example.transfertmicroservice.repositories;

import org.example.transfertmicroservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
