package org.example.transfertmicroservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.transfertmicroservice.enums.StatusBackAccount;

@Data
@AllArgsConstructor
public class Bankaccount {
    private String id;
    private String currency;
    private double balance;
    private StatusBackAccount statusBackAccount;
}
