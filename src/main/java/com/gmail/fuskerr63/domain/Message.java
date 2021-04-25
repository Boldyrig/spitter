package com.gmail.fuskerr63.domain;

import java.util.Date;

public class Message {
    private final int id;
    private final int userId;
    private final String text;
    private final String tag;
    private final Date date;

    public Message(int id, int userId, String text, String tag, Date date) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.tag = tag;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public Date getDate() {
        return date;
    }
}
