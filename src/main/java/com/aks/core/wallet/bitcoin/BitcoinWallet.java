package com.aks.core.wallet.bitcoin;

import com.aks.core.wallet.CryptoWallet;

public class BitcoinWallet implements CryptoWallet {

    private final String address;
    private final String privateAddress;
    public BitcoinWallet(String address, String privateAddress) {
        this.address = address;
        this.privateAddress = privateAddress;
    }
    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public String getPrivateKey() {
        return privateAddress;
    }
}
