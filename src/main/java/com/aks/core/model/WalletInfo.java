package com.aks.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WalletInfo {
    @JsonProperty("address")
    private String address;
    @JsonProperty("chain_stats")
    private Stats chain_stats;
    @JsonProperty("mempool_stats")
    private Stats mempool_stats;

    public WalletInfo(){}
    public WalletInfo(String address, Stats chain_stats, Stats mempool_stats) {
        this.address = address;
        this.chain_stats = chain_stats;
        this.mempool_stats = mempool_stats;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Stats getChain_stats() {
        return chain_stats;
    }

    public void setChain_stats(Stats chain_stats) {
        this.chain_stats = chain_stats;
    }

    public Stats getMempool_stats() {
        return mempool_stats;
    }

    public void setMempool_stats(Stats mempool_stats) {
        this.mempool_stats = mempool_stats;
    }
}
