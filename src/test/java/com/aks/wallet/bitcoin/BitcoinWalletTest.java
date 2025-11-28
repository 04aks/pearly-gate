package com.aks.wallet.bitcoin;

import com.aks.core.factory.CryptoWalletFactory;
import com.aks.core.wallet.CryptoWallet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitcoinWalletTest {

    private static CryptoWallet bitcoinCryptoWallet;
    @BeforeAll
    static void initAll(){
        bitcoinCryptoWallet = CryptoWalletFactory.create("BTC");
    }
    @AfterAll
    static void tearDownAll(){
        bitcoinCryptoWallet = null;
    }
    @Test
    void generateBitcoinWallet(){
        assertNotNull(bitcoinCryptoWallet.getPrivateKey());
        assertNotNull(bitcoinCryptoWallet.getPublicAddress());
    }
}
