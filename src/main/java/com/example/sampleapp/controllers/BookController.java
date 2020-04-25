package com.example.sampleapp.controllers;

import com.example.sampleapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class BookController {

    private BookRepository repository;

    @RequestMapping("/books")
    private String getBooks(Model model){
        model.addAttribute("books", repository.findAll());

        return "books";
    }
}
