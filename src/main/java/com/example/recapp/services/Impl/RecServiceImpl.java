package com.example.recapp.services.Impl;

import com.example.recapp.model.Recipe;
import com.example.recapp.services.RecService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecServiceImpl
        implements RecService {
    private Map<Integer, Recipe> recipesList = new LinkedHashMap<>();
    private static int idOfRec;

    @Override
    public void addRecipe(Recipe recipe) {
        this.recipesList.put(idOfRec++, recipe);
    }

    @Override
    public Recipe getRecipe(int idOfRec) {
        return recipesList.get(Math.abs(idOfRec));
    }
}

