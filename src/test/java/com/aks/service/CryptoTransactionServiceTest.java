package com.aks.service;

import com.aks.core.facade.Pearly;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CryptoTransactionServiceTest {
    private static Pearly pearly;
    @BeforeAll
    static void initAll(){
        pearly = new Pearly();
    }
    @AfterAll
    static void tearDownAll(){
        pearly = null;
    }
    @Test
    void isOrderPaidTest(){
        pearly.payments().checkPendingPayments();
    }
}
