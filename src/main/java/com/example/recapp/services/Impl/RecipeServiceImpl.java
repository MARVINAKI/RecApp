package com.example.recapp.services.Impl;

import com.example.recapp.model.Recipe;
import com.example.recapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl
        implements RecipeService {
    private final Map<Integer, Recipe> recipesList = new LinkedHashMap<>();
    private static int id = 1;

    @Override
    public void addRecipe(Recipe recipe) {
        this.recipesList.put(id++, recipe);
    }

    @Override
    public Recipe getRecipe(int id) {
        return recipesList.get(Math.abs(id));
    }

    @Override
    public Collection<Recipe> getAllRecipes() {
        return recipesList.values();
    }

    @Override
    public Recipe editRecipe(int id, Recipe recipe) {
        for (Integer number : recipesList.keySet()) {
            if (number == id) {
                recipesList.put(id, recipe);
                return recipe;
            }
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        for (Integer number : recipesList.keySet()) {
            if (number == id) {
                recipesList.remove(id);
                return true;
            }
        }
        return false;
    }
}