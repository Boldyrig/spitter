package com.gmail.fuskerr63.controller;

import com.gmail.fuskerr63.domain.Spitter;
import com.gmail.fuskerr63.service.ISpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private ISpitterService spitterService;

    @Autowired
    public SpitterController(ISpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String listMessagesForSpitter(
            @RequestParam("spitter") String name,
            Model model
    ) {
        Spitter spitter = spitterService.getSpitter(name);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getMessagesForSpitter(spitter));
        return "messages/list";
    }
}
