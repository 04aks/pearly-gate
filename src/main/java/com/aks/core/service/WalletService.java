package com.aks.core.service;

import com.aks.core.wallet.CryptoWallet;
import com.aks.core.wallet.CryptoWalletFactory;
import com.aks.core.wallet.bitcoin.BitcoinWalletFactory;

public class WalletService {
    public CryptoWallet create(String ticker){

        CryptoWalletFactory cryptoWalletFactory;
        CryptoWallet cryptoWallet = null;
        switch(ticker){
            case "BTC":
                cryptoWalletFactory = new BitcoinWalletFactory();
                cryptoWallet = cryptoWalletFactory.createWallet();
            break;
            case "ETH": break;
        }

        return cryptoWallet;
    }
}
