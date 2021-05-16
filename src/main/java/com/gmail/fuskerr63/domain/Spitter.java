package com.gmail.fuskerr63.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {
    public int id;

    @NotNull(message = "*null field")
    @Size(min = 3, max = 20, message = "*name length should be in [3, 20]")
    public String name;

    @NotNull(message = "*null field")
    @Size(min = 3, max = 20, message = "*username length should be in [3, 20]")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "*username should contain only letters or numbers")
    public String username;

    @NotNull(message = "*null field")
    @Size(min = 6, max = 20, message = "*password length should be in [6, 20]")
    public String password;

    @NotNull(message = "*null field")
    @Pattern(
            regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
            message = "*invalid email address"
    )
    public String email;

    public boolean updateByEmail;
    public boolean isImageUpload;

    public Spitter() {
    }

    public Spitter(int id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public Spitter(int id, String name, String username, String password, String email, boolean updateByEmail, boolean isImageUpload) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.updateByEmail = updateByEmail;
        this.isImageUpload = isImageUpload;
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

    public boolean isImageUpload() {
        return isImageUpload;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    public void setImageUpload(boolean imageUpload) {
        isImageUpload = imageUpload;
    }
}
