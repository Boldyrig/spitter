package com.gmail.fuskerr63.domain;

import java.util.Date;

public class Spitter {
    private final int id;
    private final String name;
    public final String message;
    private final String tag;
    private final Date date;

    public Spitter(int id, String name, String message, String tag, Date date) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.tag = tag;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTag() {
        return tag;
    }

    public Date getDate() {
        return date;
    }
}
