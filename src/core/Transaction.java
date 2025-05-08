package core;

import util.CryptoUtils;
import util.LoggerUtils;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class Transaction {
    PublicKey fromKey;
    PublicKey toKey;
    int amount;
    byte[] signature;
    private final long timestamp;

    public Transaction(PublicKey fromKey, PublicKey toKey, int amount) {
        this.fromKey = fromKey;
        this.toKey = toKey;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

    public boolean signTransaction(PrivateKey privateKey) {
        try {
            this.signature = CryptoUtils.signData(getData(), privateKey);
            return true;
        } catch (Exception e) {
            LoggerUtils.error("Transaction signing failed: " + e.getMessage());
            return false;
        }
    }

    public boolean verifyTransaction(PublicKey publicKey){
        try {
            return CryptoUtils.verifySign(getData(),this.signature,publicKey);
        } catch (Exception e) {
            LoggerUtils.error("Transaction verification failed: " + e.getMessage());
            return false;
        }
    }

    //Getters

    public String getData(){
        String from = Base64.getEncoder().encodeToString(fromKey.getEncoded());
        String to = Base64.getEncoder().encodeToString(toKey.getEncoded());
        return from + to + amount + timestamp;
    }

    public PublicKey getFromKey() {
        return fromKey;
    }

    public PublicKey getToKey() {
        return toKey;
    }

    public int getAmount() {
        return amount;
    }

}
