package com.aks.core.wallet.bitcoin;

import com.aks.core.service.TransactionService;
import org.bitcoinj.base.Address;
import org.bitcoinj.base.Coin;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.crypto.DumpedPrivateKey;
import org.bitcoinj.crypto.ECKey;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.wallet.Wallet;

import java.io.File;

public class BitcoinTransactionService implements TransactionService {
    @Override
    public void send(String privateKey, String toAddress, long amount) {

        // reconstruct key from wif .... well private key for other assets
        ECKey key = DumpedPrivateKey
                .fromBase58(BitcoinConfig.PARAMS.network(), privateKey)
                .getKey();

        WalletAppKit kit = new WalletAppKit(BitcoinConfig.PARAMS,
                new File("."),"wallet-" + privateKey){
            @Override
            protected void onSetupCompleted() {
                if(!wallet().hasKey(key)){
                    wallet().importKey(key);
                }
            }
        };

        kit.startAsync();
        kit.awaitRunning();
        Wallet wallet = kit.wallet();
        Address dest = Address.fromString(BitcoinConfig.PARAMS, toAddress);
        Coin coin = Coin.valueOf(amount); // amount in satoshis not btc
        try {
            Wallet.SendResult result = wallet.sendCoins(kit.peerGroup(), dest, coin);
            result.broadcastComplete.addListener(
                    () -> System.out.println("sent assets twin"),
                    Runnable::run
            );
        } catch (InsufficientMoneyException e) {
            throw new RuntimeException(e);
        }

    }
}
