package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.domain.Spitter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SpitterService implements ISpitterService{
    private List<Spitter> spitters = Arrays.asList(
            new Spitter(0, "Jack", "bla bla bla", "tag1", new Date()),
            new Spitter(1, "July", "bla bla bla", "tag1", new Date()),
            new Spitter(2, "Semen", "bla bla bla", "tag1", new Date()),
            new Spitter(3, "Sergay", "bla bla bla", "tag1", new Date()),
            new Spitter(4, "Mock", "bla bla bla", "tag1", new Date())
    );

    @Override
    public List<Spitter> getRecentSpitters(int count) {
        return spitters;
    }
}
