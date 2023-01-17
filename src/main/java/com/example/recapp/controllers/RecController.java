package com.example.recapp.controllers;

import com.example.recapp.model.Recipe;
import com.example.recapp.services.Impl.RecIngServiceImpl;
import com.example.recapp.services.RecService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecController {
    private RecService recService;


    public RecController(RecService recService) {
        this.recService = recService;
    }

    @PostMapping
    public Recipe addRec(@RequestBody Recipe recipe) {
        recService.addRecipe(recipe);
        RecIngServiceImpl.clearList();
        return recipe;
    }

    @GetMapping("/print/{id}")
    public Recipe getRec(@PathVariable int id) {
        return recService.getRecipe(id);
    }
}