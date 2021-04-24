package com.gmail.fuskerr63.controller;

import com.gmail.fuskerr63.service.ISpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
    public static final int DEFAULT_SPITTERS_PER_PAGE = 25;

    private final ISpitterService spitterService;

    @Autowired
    public HomeController(ISpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("spitters", spitterService.getRecent(DEFAULT_SPITTERS_PER_PAGE));
        return "home";
    }
}
