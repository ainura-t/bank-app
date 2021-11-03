package org.example.bank;

public class Transaction {
    private double amount;
    private double newBalance;
    private TransactionType type;

    protected Transaction(double amount, double newBalance, TransactionType type) {
        this.amount = amount;
        this.newBalance = newBalance;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", newBalance=" + newBalance +
                ", type=" + type +
                '}';
    }
}
