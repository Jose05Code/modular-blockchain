package core;

import util.LoggerUtils;

import java.util.ArrayList;
import java.util.Objects;

public class BlockChain {
    ArrayList<Block> blocks;

    public BlockChain() {
        blocks = new ArrayList<>();
    }

    public boolean addBlock(Block block){
        if(blocks.contains(block)){
            return false;
        }

        if (isValidLinkToChain(block)) {
            blocks.add(block);
            return true;
        }

        return false;
    }

    public String getLastHash(){
        return blocks.getLast().hash;
    }

    public boolean isValidLinkToChain(Block block){
        if(blocks.isEmpty())
            return true;

        return Objects.equals(getLastHash(), block.previousHash);

    }

    //Getters
    public int getBalance(User user){
        int balance = 0;
        for(Block block : blocks){
            for(Transaction transaction : block.transactions){
                if(transaction.fromKey.equals(user.publicKey)){
                    balance -= transaction.amount;
                } else if(transaction.toKey.equals(user.publicKey)){
                    balance += transaction.amount;
                }
            }
        }
        return balance;
    }
    public ArrayList<Block> getBlocks(){
        return blocks;
    }

}
