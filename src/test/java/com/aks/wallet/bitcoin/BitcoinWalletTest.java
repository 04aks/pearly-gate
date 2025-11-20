package com.aks.wallet.bitcoin;

import com.aks.core.wallet.CryptoWallet;
import com.aks.core.wallet.CryptoWalletFactory;
import com.aks.core.wallet.bitcoin.BitcoinWalletFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitcoinWalletTest {

    private static CryptoWalletFactory bitcoinWalletFactory;
    private static CryptoWallet bitcoinCryptoWallet;
    @BeforeAll
    static void initAll(){
        bitcoinWalletFactory = new BitcoinWalletFactory();
        bitcoinCryptoWallet = bitcoinWalletFactory.createWallet();
    }
    @AfterAll
    static void tearDownAll(){
        bitcoinWalletFactory = null;
        bitcoinCryptoWallet = null;
    }
    @Test
    void generateBitcoinWallet(){
        assertNotNull(bitcoinCryptoWallet.getPrivateAddress());
        assertNotNull(bitcoinCryptoWallet.getAddress());
    }
}
