package com.aks.service;

import com.aks.core.factory.TransactionServiceFactory;
import com.aks.core.service.TransactionService;
import com.aks.core.transport.HttpTransport;
import com.aks.core.util.JsonSerializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BitcoinTransactionServiceTest {
    private static TransactionService service = null;
    /*
        I will have to instantiate an HttpTransport and a JsonSerializer
        objects to run test ..... no clue if this is a sin in software dev
     */
    private static HttpTransport transport;
    private static JsonSerializer json;
    @BeforeAll
    static void initAll(){
        transport = new HttpTransport();
        json = new JsonSerializer();
        service = TransactionServiceFactory.create("BTC", transport, json);
    }
    @AfterAll
    static void tearDownAll(){
        service = null;
        transport = null;
        json = null;
    }
    @Test
    void testTransaction(){
        // String privateKey = "L2tFSg1wFpAZTgbgs3kkP2EX6B61nxtnva3GFSsGmG6zKNoofEjd";
        // String toAddress = "bc1qyy3f5p38sls4lr8pjh3k7ukg7wy3r0vtqmndqr";
        // long amount = 1000;
        // service.send(privateKey, toAddress, amount);
    }
    @Test
    void isPaidTest(){

    }
}
