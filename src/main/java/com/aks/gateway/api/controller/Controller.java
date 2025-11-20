package com.aks.gateway.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aks.core.data.DataEntry;
import com.aks.core.wallet.CryptoWallet;
import com.aks.core.wallet.CryptoWalletFactory;
import com.aks.core.wallet.bitcoin.BitcoinWalletFactory;
import com.aks.gateway.api.service.DataService;

@RestController
public class Controller {
    private final DataService dataService;
    public Controller(DataService dataService) {
        this.dataService = dataService;
    }
    
    @PostMapping("/generate-wallet")
    public void generateWallet() {
        CryptoWalletFactory bitcoinWalletFactory = new BitcoinWalletFactory();
        CryptoWallet bitcoinWallet = bitcoinWalletFactory.createWallet();
        dataService.saveDataEntry(new DataEntry(bitcoinWallet));
    }

    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
}
