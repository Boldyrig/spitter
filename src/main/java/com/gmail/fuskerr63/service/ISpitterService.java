package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.domain.Message;
import com.gmail.fuskerr63.domain.Spitter;

import java.util.List;

public interface ISpitterService{
    List<Message> getRecentSpitters(int count);
    List<Message> getMessagesForSpitter(Spitter spitter);

    Spitter getSpitter(String name);
}
