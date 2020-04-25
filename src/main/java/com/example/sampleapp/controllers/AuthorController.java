package com.example.sampleapp.controllers;

import com.example.sampleapp.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class AuthorController {

    private AuthorRepository repository;

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", repository.findAll());

        return "authors";
    }
}
