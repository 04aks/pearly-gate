package com.aks.core.data;

import com.aks.core.util.Status;
import com.aks.core.wallet.CryptoWallet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataEntry {
    @JsonIgnore
    private CryptoWallet wallet;
    @JsonProperty("wallet_address")
    private String walletAddress;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("status")
    private Status status;
    DataEntry(){}
    public DataEntry(CryptoWallet wallet){
        this.wallet = wallet;
        this.walletAddress = wallet.getAddress().toString();
        timestamp = System.currentTimeMillis();
        status = Status.PENDING;
    }
    public boolean isExpired(long millis){
        // consider a payment request to be expired after ${millis} milliseconds
        return (System.currentTimeMillis() - timestamp) > millis;
    }
    public String getWalletAddress() {
        return walletAddress;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
