package com.aks.core.wallet.solana;

import com.aks.core.wallet.CryptoWallet;
import io.github.novacrypto.base58.Base58;

import java.security.*;
import java.util.Arrays;

public class SolanaWallet implements CryptoWallet {
    private String publicAddress;
    private String privateAddress;
    public SolanaWallet(){
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("Ed25519");
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();
            byte[] privateRaw = privateKey.getEncoded();
            byte[] publicRaw = publicKey.getEncoded();
            byte[] private32 = Arrays.copyOfRange(privateRaw, privateRaw.length - 32, privateRaw.length);
            byte[] public32 = Arrays.copyOfRange(publicRaw, publicRaw.length - 32, publicRaw.length);
            byte[] secretKey64 = new byte[64];
            System.arraycopy(private32, 0, secretKey64, 0, 32);
            System.arraycopy(public32, 0, secretKey64, 32, 32);
            String base58SecretKey = Base58.base58Encode(secretKey64);
            String solAddress = Base58.base58Encode(public32);
            // wallet address ~~ I think
            setPublicAddress(solAddress);
            // private key
            setPrivateAddress(base58SecretKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getPublicAddress() {
        return publicAddress;
    }

    @Override
    public String getPrivateKey() {
        return privateAddress;
    }

    public void setPublicAddress(String publicAddress) {
        this.publicAddress = publicAddress;
    }

    public void setPrivateAddress(String privateAddress) {
        this.privateAddress = privateAddress;
    }
}
