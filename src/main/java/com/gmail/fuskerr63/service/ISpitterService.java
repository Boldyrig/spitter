package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.domain.Spitter;

public interface ISpitterService{
    Spitter getSpitterByName(String name);
    Spitter getSpitterByUsername(String name);

    boolean saveSpitter(Spitter spitter);
}
