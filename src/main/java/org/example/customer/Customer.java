package org.example.customer;

import org.example.bank.Account;
import org.example.bank.Bank;
import org.example.bank.Transaction;
import org.example.shared.User;

public class Customer extends User {
    private Account account;

    public Customer(String username, String password) {
        super(username, password);
    }

    public boolean applyForAccount(double startingBalance) {
        try {
            this.account = Bank.createAccount(this.getId(), startingBalance);
        } catch (Exception e) {
            System.out.println("UNABLE TO APPLY FOR AN ACCOUNT: " + e.getMessage());
            return false;
        }
        return true;
    }


    public void viewTransactions() {
        try {
            for (Transaction t : account.getTransactions()) {
                System.out.println(t);
            }
        } catch (Exception e) {
            System.out.println("CANNOT VIEW TRANSACTIONS: " + e.getMessage());
        }
    }

    public double getBalance() {
        return account.getBalance();
    }

    public double withdraw(double amount) {
        return account.withdraw(amount);
    }

    public double deposit(double amount) {
        return account.deposit(amount);
    }

    public double transfer(int receiverId, double amount) {
        return Bank.transfer(this.account, receiverId, amount);
    }
}
