package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.domain.Spitter;

import java.util.List;

public interface ISpitterService{
    List<Spitter> getRecentSpitters(int count);
}
