package util;

import core.Block;
import core.BlockChain;
import core.Transaction;
import core.User;

import java.util.ArrayList;

public class DisplayUtils {

    // Private constructor to prevent instantiation
    private DisplayUtils() {
        throw new UnsupportedOperationException("util.LoggerUtils is a utility class and cannot be instantiated.");
    }


    public static  void printTransaction(Transaction transaction) {
        System.out.println("    ↳ core.Transaction");
        System.out.println("      • From:    " + transaction.getFromKey().hashCode());
        System.out.println("      • To:      " + transaction.getToKey().hashCode());
        System.out.println("      • Amount:  " + transaction.getAmount());
        System.out.println("      ---------------------------");
    }

    public static void printTransactions(ArrayList<Transaction> transactions) {
        System.out.println("• Transactions  : " + transactions.size());
        System.out.println("-------------------------------------------------");
        for (Transaction transaction : transactions) {
            printTransaction(transaction);
        }
        System.out.println("=================================================\n");
    }

    public static void printBlock(Block block) {
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.println("│                 BLOCK DETAILS                 │");
        System.out.println("└───────────────────────────────────────────────┘");
        System.out.println("• Previous Hash : " + block.getPreviousHash());
        System.out.println("• Current Hash  : " + block.getHash());
        System.out.println("• Nonce         : " + block.getNonce());
        System.out.println("• Transactions  : " + block.getTransactions().size());
        printTransactions(block.getTransactions());
    }

    public static void printBlockChain(BlockChain blockChain) {
        System.out.println("\n======= BLOCKCHAIN =======");
        int index = 0;
        for (Block block : blockChain.getBlocks()) {
            System.out.println("BLOCK #" + index++);
            printBlock(block);
        }
    }

    public static void printUserInformation(User user, BlockChain blockChain) {
        System.out.println("    ↳ User Information");
        System.out.println("      • Name:    " + user.getName());
        System.out.println("      • ID:      " + user.getId());
        System.out.println("      • Public Key:  " + user.getPublicKey().hashCode());
        System.out.println("      • Amount:  " + blockChain.getBalance(user));
        System.out.println("      ---------------------------");
    }

}
