package com.example.recapp.services.Impl;

import com.example.recapp.model.Ingredient;
import com.example.recapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipesIngredientServiceImpl
        implements IngredientService {
    private static final Map<Integer, Ingredient> ingredientsList = new LinkedHashMap<>();
    private int id = 1;

    @Override
    public void addToList(Ingredient ingredient) {
        ingredientsList.put(id++, ingredient);
    }

    @Override
    public Ingredient getIngredient(int id) {
        return ingredientsList.get(id);
    }

    @Override
    public Collection<Ingredient> getAllIngredients() {
        return ingredientsList.values();
    }

    @Override
    public Ingredient editIngredient(int id, Ingredient ingredient) {
        for (Integer number : ingredientsList.keySet()) {
            if (number == id) {
                ingredientsList.put(id, ingredient);
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(int id) {
        for (Integer number : ingredientsList.keySet()) {
            if (number == id) {
                ingredientsList.remove(id);
                return true;
            }
        }
        return false;
    }
}
