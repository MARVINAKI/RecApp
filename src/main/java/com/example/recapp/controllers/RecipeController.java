package com.example.recapp.controllers;

import com.example.recapp.model.Ingredient;
import com.example.recapp.model.Recipe;
import com.example.recapp.services.IngredientService;
import com.example.recapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recService;
    private final IngredientService ingService;


    public RecipeController(RecipeService recService, IngredientService ingService) {
        this.recService = recService;
        this.ingService = ingService;
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        recService.addRecipe(recipe);
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingService.addIngredient(ingredient);
        }
        return recipe;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe recipe = recService.getRecipe(id);
        return recipe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipe);
    }

    @GetMapping("/find")
    public ResponseEntity<Collection<Recipe>> findRecByIng(@RequestParam int... id) {
        ArrayList<Recipe> list = new ArrayList<>();
        for (Recipe recipe : recService.getRecipes().values()) {
            for (int num : id) {
                if (recipe.getIngredients().contains(ingService.getIngredient(num))) {
                    if (!list.contains(recipe)) {
                        list.add(recipe);
                    }
                }
            }
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/print")
    public Collection<Recipe> getAllRecipes() {
        return recService.getAllRecipes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id,
                                             @RequestBody Recipe newRecipe) {
        Recipe recipe = recService.editRecipe(id, newRecipe);
        return recipe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        return recService.deleteRecipe(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
