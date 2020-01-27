package com.mprey.dreambot_utils.models;

public class Account {

    private String username;
    private String email;
    private String password;

    public Account() {}

    public Account(Account account) {
        this.username = account.username;
        this.email = account.email;
        this.password = account.password;
    }

    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "Account{username=" + this.username + ", email=" + this.email + ", password=" + this.password + "}";
    }
}
