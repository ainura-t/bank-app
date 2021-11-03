package org.example;

import org.example.bank.Employee;
import org.example.customer.Customer;
import org.example.dao.UserDao;
import org.example.dao.UserDaoFactory;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            Customer c = new Customer("a", "b");
            UserDao dao = UserDaoFactory.getUserDao();
            dao.addUser(c);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
}
