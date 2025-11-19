package com.aks.core.wallet.bitcoin;

import com.aks.core.wallet.CryptoWallet;
import com.aks.core.wallet.CryptoWalletFactory;

public class BitcoinWalletFactory implements CryptoWalletFactory {
    @Override
    public CryptoWallet createWallet() {
        return new BitcoinWallet();
    }
}
