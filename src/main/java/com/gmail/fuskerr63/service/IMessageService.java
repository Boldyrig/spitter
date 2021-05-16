package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.domain.Message;
import com.gmail.fuskerr63.domain.Spitter;

import java.util.List;

public interface IMessageService {
    List<Message> getRecentMessages(int count);
    List<Message> getMessagesForSpitter(Spitter spitter);

    void addMessage(Message message);
}
