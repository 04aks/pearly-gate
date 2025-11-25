package com.aks.core.service;

public interface TransactionService {
    void send(String privateKey, String toAddress, long amount);
}
