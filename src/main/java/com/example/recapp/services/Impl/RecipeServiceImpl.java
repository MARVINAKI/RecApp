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
    private final Map<Integer, Recipe> recipes = new LinkedHashMap<>();
    private static int id = 1;

    @Override
    public final void addRecipe(Recipe recipe) {
        this.recipes.put(id++, recipe);
    }

    @Override
    public final Recipe getRecipe(int id) {
        return recipes.get(Math.abs(id));
    }

    @Override
    public final Collection<Recipe> getAllRecipes() {
        return recipes.values();
    }

    @Override
    public final Recipe editRecipe(int id, Recipe recipe) {
        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public final boolean deleteRecipe(int id) {
        Recipe recipe = recipes.remove(id);
        return recipe != null;
    }

    @Override
    public final Map<Integer, Recipe> getRecipes() {
        return recipes;
    }
}