package com.aks.core.factory;

import com.aks.core.wallet.CryptoWallet;
import com.aks.core.wallet.bitcoin.BitcoinWallet;
import com.aks.core.wallet.solana.SolanaWallet;

public final class CryptoWalletFactory {
    public static CryptoWallet create(String ticker){
        CryptoWallet wallet = null;
        switch(ticker.toUpperCase()){
            case "BTC": wallet = new BitcoinWallet(); break;
            case "SOL": wallet = new SolanaWallet(); break;
        }
        return wallet;
    }
}
