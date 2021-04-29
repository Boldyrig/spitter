package com.gmail.fuskerr63.controller;

import com.gmail.fuskerr63.domain.Spitter;
import com.gmail.fuskerr63.service.ISpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
        model.addAttribute("spitter", spitter);
        model.addAttribute("messages", spitterService.getMessagesForSpitter(spitter));
        return "messages/list";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = RequestMethod.POST, params = "new")
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "spitters/edit";
        }
        spitterService.saveSpitter(spitter);
        return "redirect:/spitters/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spiters/view";
    }
}
