package org.example.shared;

import java.util.regex.Pattern;

public class User {
    private static int LAST_ID = 0;
    private int id;
    private String username;
    private String password;
    private boolean isLoggedIn;


    public User(String username, String password) {
        // we register here
        this.id = LAST_ID++;
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return this.id;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    // check in the database if credentials are correct
    public boolean login(String username, String password) {
        if (this.isLoggedIn) {
            System.out.println("Already logged in");
        } else {
            if (username.length() > 0 && password.length() > 0) {
                System.out.println("Logging in");
                this.isLoggedIn = true;
            } else {
                System.out.println("Invalid credentials");
            }
        }
        return this.isLoggedIn;
    }
}
