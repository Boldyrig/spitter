package com.gmail.fuskerr63.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "text")
    private String text;

    @Column(name = "tag")
    private String tag;

    @Column(name = "date")
    private Date date;

    public Message(int id, int userId, String userName, String text, String tag, Date date) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.tag = tag;
        this.date = date;
    }

    public Message() {

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

    public String getUserName() {
        return userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
