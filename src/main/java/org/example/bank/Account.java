package org.example.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int ownerId;
    private double balance;
    private AccountStatus accountStatus;
    private List<Transaction> transactions;

    protected Account(int ownerId, double startingBalance) throws Exception
    {
        this.checkIfValidAmount(startingBalance);
        this.ownerId = ownerId;
        this.accountStatus = AccountStatus.PENDING;
        this.balance += startingBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add(new Transaction(startingBalance, this.balance, TransactionType.DEPOSIT));
    }

    private void checkIfApproved() throws Exception {
        if (this.accountStatus == AccountStatus.REJECTED) {
            throw new Exception("The account is permanently rejected.");
        }
        if (this.accountStatus == AccountStatus.PENDING) {
            throw new Exception("The account isn't approved yet.");
        }
    }

    private void checkIfValidAmount(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Invalid amount.");
        }
    }

    private void checkIfValidWithdrawal(double amount) throws Exception {
        this.checkIfValidAmount(amount);
        if (this.balance < amount) {
            throw new Exception("Insufficient funds.");
        }
    }

    protected int getOwnerId() {
        return this.ownerId;
    }

    public double getBalance() {
        return balance;
    }

    protected boolean approve() {
        this.accountStatus = AccountStatus.APPROVED;
        return true;
    }

    protected boolean reject() {
        this.accountStatus = AccountStatus.REJECTED;
        return true;
    }

    public double withdraw(double amount) {
        try {
            this.checkIfApproved();
            this.checkIfValidWithdrawal(amount);
            this.balance -= amount;
            this.transactions.add(new Transaction(amount, this.balance, TransactionType.WITHDRAWAL));
        } catch (Exception e) {
            // log
            System.out.println("TRANSACTION REJECTED: " +e.getMessage());
        }
        return this.balance;
    }

    public double deposit(double amount) {
        try {
            this.checkIfApproved();
            this.checkIfValidAmount(amount);
            this.balance += amount;
            this.transactions.add(new Transaction(amount, this.balance, TransactionType.DEPOSIT));
        } catch (Exception e) {
            // log
            System.out.println("TRANSACTION REJECTED: " + e.getMessage());
        }
        return this.balance;
    }

    public List<Transaction> getTransactions() throws Exception {
        this.checkIfApproved();
        return this.transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerId=" + ownerId +
                ", balance=" + balance +
                ", accountStatus=" + accountStatus +
                ", transactions=" + transactions +
                '}';
    }
}
