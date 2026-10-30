package org.example.accountservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.accountservice.enums.StatusBackAccount;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bankaccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String currency;
    private double balance;
    private StatusBackAccount statusBackAccount;
    @ManyToOne
    private Customer customer;


}
