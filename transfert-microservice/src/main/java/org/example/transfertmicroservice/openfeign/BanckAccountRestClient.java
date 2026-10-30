package org.example.transfertmicroservice.openfeign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.transfertmicroservice.Models.Bankaccount;
import org.example.transfertmicroservice.enums.StatusBackAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name ="account-Service")
public interface BanckAccountRestClient {
    @CircuitBreaker(name = "accountbyid", fallbackMethod = "getDefaultBankaccount")

    @GetMapping("/api/bankaccounts/{id}")
    Bankaccount getBankaccountById(@PathVariable String id );

    default Bankaccount getDefaultBankaccount( String id,Exception e ) {
        return new Bankaccount(id,"NoCuurency",0, StatusBackAccount.BLOCKED);
    }



    @GetMapping("/api/bankaccounts")
    List<Bankaccount> getBankaccounts( );


}
