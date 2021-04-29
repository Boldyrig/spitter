package com.gmail.fuskerr63.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {
    private int id;
    @Size(min = 3, max = 20, message = "name length should be in [3, 20]")
    private String name;
    @Size(min = 3, max = 20, message = "username length should be in [3, 20]")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "username should contain only letters or numbers")
    private String username;
    @Size(min = 6, max = 20, message = "password length should be in [6, 20]")
    private String password;
    @Pattern(
            regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
            message = "invalid email address"
    )
    private String email;
    private boolean updateByEmail;

    public Spitter() {
    }

    public Spitter(int id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }
}
