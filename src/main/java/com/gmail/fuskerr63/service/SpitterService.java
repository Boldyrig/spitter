package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.dao.SpitterDAO;
import com.gmail.fuskerr63.domain.Message;
import com.gmail.fuskerr63.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SpitterService implements ISpitterService {
    @Autowired
    private SpitterDAO spitterDAO;

    private List<Spitter> spitters = Arrays.asList(
            new Spitter(0, "Jack", "nagibator"),
            new Spitter(1, "July", "julyyy"),
            new Spitter(2, "Semen", "semenJS"),
            new Spitter(3, "Sergay", "imgay"),
            new Spitter(4, "Mock", "jorik2021")
    );

    private final List<Message> messages = Arrays.asList(
            new Message(0, 2, "Hello?", "", new Date(2021, 9, 3)),
            new Message(0, 3, "fff?", "", new Date(2020, 7, 3)),
            new Message(0, 4, "Helsdfsdflo?", "", new Date(2021, 9, 3)),
            new Message(0, 2, "Heldfddlo?", "", new Date(2019, 9, 3)),
            new Message(0, 1, "Helddfdsflo?", "", new Date(2021, 9, 3)),
            new Message(0, 0, "Heasdfsadfllo?", "", new Date(2021, 9, 3)),
            new Message(0, 0, "Helasdfsadflo?", "", new Date(2021, 9, 3)),
            new Message(0, 2, "Helasdfsdflo?", "", new Date(2021, 9, 3)),
            new Message(0, 4, "Heldfdsflo?", "", new Date(2021, 9, 3))
    );

    @Override
    @Deprecated
    public List<Message> getRecentSpitters(int count) {
        return messages;
    }

    @Override
    @Deprecated
    public List<Message> getMessagesForSpitter(Spitter spitter) {
        List<Message> messages = new ArrayList<>();
        for(Message message : this.messages) {
            if(message.getUserId() == spitter.getId()) {
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    @Deprecated
    public Spitter getSpitterByName(String name) {
        for(Spitter spitter : spitters) {
            if(spitter.getName().equals(name)) {
                return spitter;
            }
        }
        return null;
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return spitterDAO.getSpitterByUsername(username);
    }

    @Override
    public boolean saveSpitter(Spitter spitter) {
        Spitter spitterDb = getSpitterByUsername(spitter.getUsername());
        if (spitterDb == null) {
            spitterDAO.addSpitter(spitter);
            return true;
        }
        return false;
    }
}
