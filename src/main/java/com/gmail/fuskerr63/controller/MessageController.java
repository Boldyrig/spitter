package com.gmail.fuskerr63.controller;

import com.gmail.fuskerr63.domain.Message;
import com.gmail.fuskerr63.domain.Spitter;
import com.gmail.fuskerr63.service.IMessageService;
import com.gmail.fuskerr63.service.ISpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/message")
public class MessageController {
    IMessageService messageService;
    ISpitterService spitterService;

    @Autowired
    public void setMessageService(IMessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    public void setSpitterService(ISpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(method = RequestMethod.GET, params = "username")
    public String listMessagesForSpitter(
            @RequestParam("username") String username,
            Model model
    ) {
        Spitter spitter = spitterService.getSpitterByUsername(username);
        model.addAttribute("spitter", spitter);
        model.addAttribute("messages", messageService.getMessagesForSpitter(spitter));
        model.addAttribute("message", new Message());
        return "messages/list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addMessageFromForm(Message message) {
        messageService.addMessage(message);
        return "redirect:message?username=" + message.getUserName();
    }
}
