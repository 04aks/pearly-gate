package com.aks.core.service;

import com.aks.core.data.DataEntry;
import com.aks.core.model.WalletInfo;
import com.aks.core.transport.HttpTransport;
import com.aks.core.util.JsonSerializer;
import com.aks.core.wallet.bitcoin.BitcoinConfig;
import org.bitcoinj.base.Address;
import org.bitcoinj.base.Coin;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.crypto.DumpedPrivateKey;
import org.bitcoinj.crypto.ECKey;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.wallet.Wallet;

import java.io.File;

public class BitcoinTransactionService implements TransactionService {

    private final HttpTransport transport;
    private final JsonSerializer json;
    public BitcoinTransactionService(HttpTransport transport, JsonSerializer json){
        this.transport = transport;
        this.json = json;
    }
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
    @Override
    public boolean isPaid(DataEntry dataEntry) {
        String walletInfoUrl = "https://blockstream.info/api/address/";
        String response = transport.get(walletInfoUrl + dataEntry.getWalletAddress(), null);
        WalletInfo walletInfo = json.fromJson(response, WalletInfo.class);
        return walletInfo.getChain_stats().getFunded_txo_count() >= 1;
    }
}
