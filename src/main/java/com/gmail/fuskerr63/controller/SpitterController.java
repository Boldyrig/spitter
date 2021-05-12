package com.gmail.fuskerr63.controller;

import com.gmail.fuskerr63.domain.ShortSpitter;
import com.gmail.fuskerr63.domain.Spitter;
import com.gmail.fuskerr63.service.ISpitterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        boolean isSpitterSaved = spitterService.saveSpitter(spitter);

        if(!isSpitterSaved) {
            bindingResult.rejectValue("username", "error.spitter", "already exist in database");
            return "edit";
        }

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

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public String authenticationSpitter(
            ShortSpitter shortSpitter,
            BindingResult bindingResult,
            Model model
    ) {
        Spitter spitter = spitterService.getSpitterByUsername(shortSpitter.getUsername());
        if(spitter != null && spitter.getPassword().equals(shortSpitter.getPassword())) { //TODO
            return "redirect:/spitter/" + spitter.getUsername();
        }
        return "home";
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
