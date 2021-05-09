package com.gmail.fuskerr63.controller;

import com.gmail.fuskerr63.domain.Message;
import com.gmail.fuskerr63.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    public static final int DEFAULT_SPITTERS_PER_PAGE = 25;

    private final IMessageService messageService;

    @Autowired
    public HomeController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping
    public String showHomePage(Map<String, Object> model) {
        List<Message> messages = messageService.getRecentMessages(DEFAULT_SPITTERS_PER_PAGE);
        model.put("messages", messages);
        return "home";
    }
}
