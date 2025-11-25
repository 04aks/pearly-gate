package com.aks.core.wallet.bitcoin;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;

public class BitcoinConfig {
    public static NetworkParameters PARAMS = MainNetParams.get();
}
