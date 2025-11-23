package com.aks.gateway.api.service;

import com.aks.core.facade.Pearly;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class PaymentChecker {
    private final Pearly pearly;
    public PaymentChecker(Pearly pearly){
        this.pearly = pearly;
    }
    @Scheduled(fixedRate = 10_000)
    public void checkPayment(){
        System.out.println("checking payments");
        pearly.payments().checkPendingPayments();
    }
}
