package org.example.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private static Map<Integer, Account> accounts = new HashMap<>();

    // so we cannot create an instance of a bank
    private Bank() {
    }

    public static Account createAccount(int userId, double startingBalance) throws Exception {
        Account account = new Account(userId, startingBalance);
        accounts.put(userId, account);
        return account;
    }


    protected static boolean approveAccount(int userId) throws Exception {
        Account account = Bank.getAccount(userId);
        return account.approve();
    }

    protected static boolean rejectAccount(int userId) throws Exception {
        Account account = Bank.getAccount(userId);
        return account.reject();
    }

    protected static List<Account> getAccounts() {
        return new ArrayList<>(accounts.values());
    }

    public static Account getAccount(int userId) throws Exception {
        Account account = accounts.get(userId);
        if (account == null) {
            throw new Exception("Account " + userId + " doesn't exist");
        }
        return account;
    }

    public static double transfer(Account fromAccount, int toId, double amount) {
        try {
            if(fromAccount.getOwnerId() == toId) {
                throw new Exception("Cannot transfer to the same account");
            }
            Account toAccount = Bank.getAccount(toId);
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } catch (Exception e) {
            System.out.println("TRANSFER FAILED: " + e.getMessage());
        }
        return fromAccount.getBalance();
    }
}
