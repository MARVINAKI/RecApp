package com.example.recapp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Страница приветсвия")
public class MainController {
    @GetMapping
    public String test() {
        return "Web-приложение для сайта рецептов";
    }
}
