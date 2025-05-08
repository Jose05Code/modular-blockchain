package app;

import core.*;
import util.DisplayUtils;
import util.LoggerUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        TransactionPool transactionPool = new TransactionPool();

        users.add(new User("Bank"));
        users.add(new User("John"));

        Transaction transaction;
        transaction = new Transaction(users.get(0).getPublicKey(), users.get(1).getPublicKey(), 50);
        if(transaction.signTransaction(users.get(0).getPrivateKey())){
            transactionPool.addTransaction(transaction);
        } else {
            LoggerUtils.error("Transaction signing failed");
        }

        BlockChain blockChain = new BlockChain();
        if(blockChain.addBlock(new Block("00", transactionPool.getPool()))){
            LoggerUtils.success("Added block");
        }else{
            LoggerUtils.error("Failed to add block");
        }
        transactionPool.resetPool();

        DisplayUtils.printBlockChain(blockChain);
        DisplayUtils.printUserInformation(users.get(1), blockChain);
    }
}