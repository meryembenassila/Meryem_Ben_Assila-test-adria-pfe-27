package org.example.accountservice.repositories;

import org.example.accountservice.entities.Bankaccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanckAccountRepository extends JpaRepository<Bankaccount, String> {
}

