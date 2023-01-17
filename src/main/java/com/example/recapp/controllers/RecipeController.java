package com.example.recapp.controllers;

import com.example.recapp.model.Recipe;
import com.example.recapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recService;


    public RecipeController(RecipeService recService) {
        this.recService = recService;
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        recService.addRecipe(recipe);
        return recipe;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe recipe = recService.getRecipe(id);
        return recipe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipe);
    }
//
//    @GetMapping("/print")
//    public Collection<Recipe> getAllRecipes() {
//        return recService.getAllRecipes();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Recipe> editRecipe(@PathVariable int id,
//                                             @RequestBody Recipe newRecipe) {
//        Recipe recipe = recService.editRecipe(id, newRecipe);
//        return recipe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipe);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
//        return recService.deleteRecipe(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
//    }
}
