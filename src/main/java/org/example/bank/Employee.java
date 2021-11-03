package org.example.bank;

import org.example.customer.Customer;

public class Employee extends Customer {

    public Employee(String username, String password) {
        super(username, password);
    }

    public boolean approveAccount(int accountId) {
        try {
            return Bank.approveAccount(accountId);
        } catch (Exception e) {
            System.out.println("UNABLE TO APPROVE ACCOUNT: " + e.getMessage());
            return false;
        }
    }

    public boolean rejectAccount(int accountId) {
        try {
            return Bank.rejectAccount(accountId);
        } catch (Exception e) {
            System.out.println("UNABLE TO REJECT ACCOUNT: " + e.getMessage());
            return false;
        }
    }

    public void viewAccounts() {
        for (Account a : Bank.getAccounts()) {
            System.out.println(a);
        }
    }

    public void viewAccount(int userId) {
        try {
            System.out.println(Bank.getAccount(userId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
