package com.example.recapp.controllers;

import com.example.recapp.model.Ingredient;
import com.example.recapp.services.IngService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ingredients")
public class IngController {
    private IngService ingService;

    public IngController(IngService ingService) {
        this.ingService = ingService;
    }

    @PostMapping
    public Ingredient addIng(@RequestBody Ingredient ingredient) {
        ingService.addToList(ingredient);
        return ingredient;
    }

    @GetMapping("/print/{id}")
    public Ingredient getIng(@PathVariable int id) {
        return ingService.getIngredient(id);
    }
}