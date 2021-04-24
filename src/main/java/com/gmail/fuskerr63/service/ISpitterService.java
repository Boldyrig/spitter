package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.dao.Spitter;

import java.util.List;

public interface ISpitterService{
    List<Spitter> getRecent(int count);
}
