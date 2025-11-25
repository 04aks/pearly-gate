package com.aks.core.wallet.bitcoin;

import com.aks.core.wallet.CryptoWallet;
import com.aks.core.wallet.CryptoWalletFactory;
import org.bitcoinj.base.Address;
import org.bitcoinj.base.ScriptType;
import org.bitcoinj.crypto.ECKey;

public class BitcoinWalletFactory implements CryptoWalletFactory {
    @Override
    public CryptoWallet createWallet() {
        ECKey key = new ECKey();
        Address address = key.toAddress(ScriptType.P2WPKH, BitcoinConfig.PARAMS.network());
        String wif = key.getPrivateKeyAsWiF(BitcoinConfig.PARAMS.network());
        return new BitcoinWallet(address.toString(), wif);
    }
}
