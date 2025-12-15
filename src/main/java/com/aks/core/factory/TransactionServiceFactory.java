package com.aks.core.factory;

import com.aks.core.service.SolanaTransactionService;
import com.aks.core.service.TransactionService;
import com.aks.core.service.BitcoinTransactionService;
import com.aks.core.transport.HttpTransport;
import com.aks.core.util.JsonSerializer;

public class TransactionServiceFactory {
    public static TransactionService create(String ticker, HttpTransport transport, JsonSerializer json){
        TransactionService service = null;
        switch(ticker.toUpperCase()){
            case "BTC": service = new BitcoinTransactionService(transport, json); break;
            case "SOL": service = new SolanaTransactionService(transport, json); break;
        }
        return service;
    }
}
