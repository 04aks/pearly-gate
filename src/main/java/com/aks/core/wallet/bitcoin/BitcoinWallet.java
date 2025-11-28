package com.aks.core.wallet.bitcoin;

import com.aks.core.wallet.CryptoWallet;
import org.bitcoinj.base.Address;
import org.bitcoinj.base.ScriptType;
import org.bitcoinj.crypto.ECKey;

public class BitcoinWallet implements CryptoWallet {

    private final String publicAddress;
    private final String privateAddress;
    public BitcoinWallet() {
        ECKey key = new ECKey();
        Address address = key.toAddress(ScriptType.P2WPKH, BitcoinConfig.PARAMS.network());
        String wif = key.getPrivateKeyAsWiF(BitcoinConfig.PARAMS.network());
        this.publicAddress = address.toString();
        this.privateAddress = wif;
    }
    @Override
    public String getPublicAddress() {
        return publicAddress;
    }
    @Override
    public String getPrivateKey() {
        return privateAddress;
    }
}
