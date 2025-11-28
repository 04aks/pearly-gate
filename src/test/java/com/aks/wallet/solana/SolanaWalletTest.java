package com.aks.wallet.solana;

import com.aks.core.factory.CryptoWalletFactory;
import com.aks.core.wallet.CryptoWallet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SolanaWalletTest {
    private static CryptoWallet wallet;
    @BeforeAll
    static void initAll(){
        wallet = CryptoWalletFactory.create("SOL");
    }
    @AfterAll
    static void tearDownAll(){
        wallet = null;
    }
    @Test
    void generateSolanaWallet(){
        // joke man test class; already generated the wallet above
        System.out.println(wallet.getPublicAddress());
        System.out.println(wallet.getPrivateKey());
    }
}
