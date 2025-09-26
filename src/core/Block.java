package core;
import util.ProjectUtils;
import java.util.ArrayList;

public class Block {
    String previousHash;
    String hash;
    String nonce;
    ArrayList<Transaction> transactions;
    private final long timestamp;

    public Block(String previousHash, ArrayList<Transaction> transactions){
        this.previousHash = previousHash;
        this.nonce = "0";
        this.transactions = transactions;
        this.timestamp = System.currentTimeMillis();
        this.hash = mineBlock(1);
    }

    public String calculateHash() {
        StringBuilder transactionsData = new StringBuilder();
        for (Transaction transaction : transactions) {
            transactionsData.append(transaction.getData());
        }

        String dataToHash = previousHash + transactionsData + nonce + timestamp;
        return ProjectUtils.sha256(dataToHash);
    }

    public String mineBlock(int difficulty) {
        nonce = "0";
        hash = calculateHash();
        String difficulty_str = "";
        for (int i = 0; i < difficulty; i++) {
            difficulty_str = difficulty_str + "0";
        }

        while(!hash.startsWith(difficulty_str)){
            int newNonce = Integer.parseInt(nonce);
            newNonce++;
            nonce = Integer.toString(newNonce);
            hash = calculateHash();
        }
  
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return hash.equals(block.hash);
    }

    @Override
    public int hashCode() {
        return hash.hashCode();
    }

    //Getters
    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public String getNonce() {
        return nonce;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
