package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.domain.Spitter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpitterService implements ISpitterService{
    private List<Spitter> spitters = Arrays.asList(
            new Spitter(0, "Jack", "bla bla bla", "tag1"),
            new Spitter(1, "Jack", "bla bla bla", "tag1"),
            new Spitter(2, "Jack", "bla bla bla", "tag1"),
            new Spitter(3, "Jack", "bla bla bla", "tag1"),
            new Spitter(4, "Jack", "bla bla bla", "tag1")
    );

    @Override
    public List<Spitter> getRecentSpitters(int count) {
        return spitters;
    }
}
