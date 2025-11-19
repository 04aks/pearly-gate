package com.aks.core.wallet;

import org.bitcoinj.base.Address;

public abstract class CryptoWallet {
    private String privateAddress;
    private Address address;
    public abstract void generateAddress();
    public abstract void printAddress();
    public String getPrivateAddress() {
        return privateAddress;
    }
    public Address getAddress() {
        return address;
    }

    public void setPrivateAddress(String privateAddress) {
        this.privateAddress = privateAddress;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
