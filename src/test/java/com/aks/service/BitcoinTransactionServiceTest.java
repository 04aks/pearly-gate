package com.aks.service;

import com.aks.core.factory.TransactionServiceFactory;
import com.aks.core.service.TransactionService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BitcoinTransactionServiceTest {
    private static TransactionService service = null;
    @BeforeAll
    static void initAll(){
        service = TransactionServiceFactory.create("BTC");
    }
    @AfterAll
    static void tearDownAll(){
        service = null;
    }
    @Test
    void testTransaction(){
        String privateKey = "L2tFSg1wFpAZTgbgs3kkP2EX6B61nxtnva3GFSsGmG6zKNoofEjd";
        String toAddress = "bc1qyy3f5p38sls4lr8pjh3k7ukg7wy3r0vtqmndqr";
        long amount = 1000;
        service.send(privateKey, toAddress, amount);
    }
}
