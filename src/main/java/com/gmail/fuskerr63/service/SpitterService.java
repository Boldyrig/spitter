package com.gmail.fuskerr63.service;

import com.gmail.fuskerr63.dao.SpitterDAO;
import com.gmail.fuskerr63.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpitterService implements ISpitterService {

    private SpitterDAO spitterDAO;

    @Autowired
    public void setSpitterDAO(SpitterDAO spitterDAO) {
        this.spitterDAO = spitterDAO;
    }

    private List<Spitter> spitters = Arrays.asList(
            new Spitter(0, "Jack", "nagibator"),
            new Spitter(1, "July", "julyyy"),
            new Spitter(2, "Semen", "semenJS"),
            new Spitter(3, "Sergay", "imgay"),
            new Spitter(4, "Mock", "jorik2021")
    );
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
