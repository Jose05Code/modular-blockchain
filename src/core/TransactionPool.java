package core;

import java.util.ArrayList;
public class TransactionPool {
    private final ArrayList<Transaction> transactions;
    public TransactionPool() {
        transactions = new ArrayList<>();
    }
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void resetPool() {
        transactions.clear();
    }

    public void printPool() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions");
        }
        else for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public ArrayList<Transaction> getPool() {
        return transactions;
    }
}
