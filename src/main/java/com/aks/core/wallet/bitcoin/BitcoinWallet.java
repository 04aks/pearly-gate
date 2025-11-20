package com.aks.core.wallet.bitcoin;

import com.aks.core.wallet.CryptoWallet;
import org.bitcoinj.base.ScriptType;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.crypto.ECKey;
import org.bitcoinj.params.MainNetParams;

public class BitcoinWallet extends CryptoWallet {

    public BitcoinWallet() {
        generateWallet();
    }
    @Override
    public void generateWallet() {
        NetworkParameters params = MainNetParams.get();
        ECKey key = new ECKey();
        setAddress(key.toAddress(ScriptType.P2WPKH, params.network()));
        setPrivateAddress(key.getPrivateKeyAsWiF(params.network()));
    }

    @Override
    public void printAddress() {
        System.out.println(getAddress() + "\n" + getPrivateAddress());
    }
}
