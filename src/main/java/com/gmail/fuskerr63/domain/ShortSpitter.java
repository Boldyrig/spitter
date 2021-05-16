package com.gmail.fuskerr63.domain;

public class ShortSpitter {
    private String username;
    private String password;

    public ShortSpitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ShortSpitter() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
