package com.aks.core.model;

public class Stats {
    private long funded_txo_count;
    private long funded_txo_sum;
    private long spent_txo_count;
    private long spent_txo_sum;
    private long tx_count;

    public Stats(){}

    public Stats(long funded_txo_count, long funded_txo_sum, long spent_txo_count, long spent_txo_sum, long tx_count) {
        this.funded_txo_count = funded_txo_count;
        this.funded_txo_sum = funded_txo_sum;
        this.spent_txo_count = spent_txo_count;
        this.spent_txo_sum = spent_txo_sum;
        this.tx_count = tx_count;
    }

    public void setFunded_txo_count(long funded_txo_count) {
        this.funded_txo_count = funded_txo_count;
    }

    public void setFunded_txo_sum(long funded_txo_sum) {
        this.funded_txo_sum = funded_txo_sum;
    }

    public void setSpent_txo_count(long spent_txo_count) {
        this.spent_txo_count = spent_txo_count;
    }

    public void setSpent_txo_sum(long spent_txo_sum) {
        this.spent_txo_sum = spent_txo_sum;
    }

    public void setTx_count(long tx_count) {
        this.tx_count = tx_count;
    }

    public long getFunded_txo_count() {
        return funded_txo_count;
    }

    public long getFunded_txo_sum() {
        return funded_txo_sum;
    }

    public long getSpent_txo_count() {
        return spent_txo_count;
    }

    public long getSpent_txo_sum() {
        return spent_txo_sum;
    }

    public long getTx_count() {
        return tx_count;
    }
}
