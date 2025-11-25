package com.aks.gateway.api.controller;

import com.aks.core.facade.Pearly;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aks.core.data.DataEntry;
import com.aks.core.wallet.CryptoWallet;

@RestController
public class Controller {
    private final Pearly pearly;
    public Controller(Pearly pearly){
        this.pearly = pearly;
    }

    @PostMapping("/generate-wallet")
    public void generateWallet() {
        CryptoWallet wallet = pearly.wallet().create("BTC");
        pearly.payments().addPayment(new DataEntry(wallet));
    }
    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
}
