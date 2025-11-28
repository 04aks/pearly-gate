package com.aks.core.factory;

import com.aks.core.service.TransactionService;
import com.aks.core.service.BitcoinTransactionService;

public class TransactionServiceFactory {
    public static TransactionService create(String ticker){
        TransactionService service = null;
        switch(ticker){
            case "BTC": service = new BitcoinTransactionService(); break;
            case "ETH": System.out.println("soon"); break;
        }
        return service;
    }
}
