package com.gmail.fuskerr63.controller;

import com.gmail.fuskerr63.domain.Spitter;
import com.gmail.fuskerr63.service.ISpitterService;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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
        Spitter spitter = spitterService.getSpitterByName(name);
        model.addAttribute("spitter", spitter);
        model.addAttribute("messages", spitterService.getMessagesForSpitter(spitter));
        return "messages/list";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute("spitter", new Spitter());
        return "edit";
    }

    @RequestMapping(method = RequestMethod.POST, params = "new")
    public String addSpitterFromForm(
            @Valid Spitter spitter,
            BindingResult bindingResult,
            @RequestParam(value = "image", required = false)MultipartFile image) {
        if(bindingResult.hasErrors()) {
            return "edit";
        }
        spitterService.saveSpitter(spitter);


        try {
            if(!image.isEmpty()) {
                validateImage(image);
                saveImage(spitter.getId() + ".jpg", image);
            }
        } catch(ImageUploadException e) {
            bindingResult.reject(e.getMessage());
            return "edit";
        }

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterService.getSpitterByUsername(username);
        model.addAttribute(spitter);
        return "spitter/profile";
    }

    private void validateImage(MultipartFile image) {
        if(!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    private void saveImage(String filename, MultipartFile image) throws ImageUploadException {
        try {
            File file = new File( "src/main/webapp/resources/" + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image", e);
        }
    }

    private static class ImageUploadException extends RuntimeException {
        public ImageUploadException(String message) {
            super(message);
        }

        public ImageUploadException(String message, Throwable throwable) {
            super(message, throwable);
        }
    }
}
