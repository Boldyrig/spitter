package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.dao.MessageDAO;
import com.gmail.fuskerr63.domain.Message;
import com.gmail.fuskerr63.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageService implements IMessageService {
    private MessageDAO messageDAO;

    @Autowired
    public void setMessageDAO(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public List<Message> getRecentMessages(int count) {
        return messageDAO.getMessages(count);
    }

    @Override
    public List<Message> getMessagesForSpitter(Spitter spitter) {
        return messageDAO.getMessagesByUserId(spitter.getId());
    }

    @Override
    public void addMessage(Message message) {
        messageDAO.addMessage(message);
    }
}
