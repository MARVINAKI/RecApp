package com.example.recapp.controllers;

import com.example.recapp.model.Ingredient;
import com.example.recapp.services.IngService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ingredients")
public class IngController {
    private IngService ingService;

    public IngController(IngService ingService) {
        this.ingService = ingService;
    }

    @GetMapping
    public String addIng(@RequestParam String title,
                         @RequestParam double amount,
                         @RequestParam String unit) {
        ingService.addToList(new Ingredient(title, amount, unit));
        return "Ингредиент " + title + " успешно добавлен";
    }

    @GetMapping("/print")
    public Ingredient getIng(@RequestParam int id) {
        return ingService.getIngredient(id);
    }
}
