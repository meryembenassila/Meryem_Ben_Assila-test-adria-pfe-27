package org.example.transfertmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.transfertmicroservice.Models.Bankaccount;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private double ammount;
    private String merchantCategory;
    private String country;
    private Date CreatedAt;
    private String currency;
    private String bankaccountid;
    @Transient
    private Bankaccount bankaccount;

}
