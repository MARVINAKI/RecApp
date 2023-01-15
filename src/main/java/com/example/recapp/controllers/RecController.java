package com.example.recapp.controllers;

import com.example.recapp.model.Recipe;
import com.example.recapp.services.Impl.RecIngServiceImpl;
import com.example.recapp.services.RecService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecController {
    private RecService recService;


    public RecController(RecService recService) {
        this.recService = recService;
    }

    @GetMapping
    public String addRec(@RequestParam String title,
                         @RequestParam int time,
                         @RequestParam String... steps) {
        recService.addRecipe(new Recipe(title,time,steps));
        RecIngServiceImpl.clearList();
        return "Рецепт " + title + " успешно добавлен";
    }

    @GetMapping("/print")
    public Recipe getRec(int id) {
        return recService.getRecipe(id);
    }
}
