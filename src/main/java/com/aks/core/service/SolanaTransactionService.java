package com.aks.core.service;

import com.aks.core.data.DataEntry;
import com.aks.core.transport.HttpTransport;
import com.aks.core.util.JsonSerializer;

public class SolanaTransactionService implements TransactionService{
    private final HttpTransport transport;
    private final JsonSerializer json;
    public SolanaTransactionService(HttpTransport transport, JsonSerializer json){
        this.transport = transport;
        this.json = json;
    }
    @Override
    public void send(String privateKey, String toAddress, long amount) {

    }

    @Override
    public boolean isPaid(DataEntry dataEntry) {
        System.out.println("isPaid not implemented yet for Solana");
        return false;
    }
}
