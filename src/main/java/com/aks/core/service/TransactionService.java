package com.aks.core.service;

import com.aks.core.data.DataEntry;

public interface TransactionService {
    void send(String privateKey, String toAddress, long amount);
    boolean isPaid(DataEntry dataEntry);
}
