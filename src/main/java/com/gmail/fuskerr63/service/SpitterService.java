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
