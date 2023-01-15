package com.example.recapp.services.Impl;

import com.example.recapp.model.Ingredient;
import com.example.recapp.services.IngService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecIngServiceImpl
        implements IngService {
    private static final Map<Integer, Ingredient> ingredientsList = new LinkedHashMap<>();
    private int idOfIng;

    @Override
    public void addToList(Ingredient ingredient) {
        ingredientsList.put(idOfIng++, ingredient);
    }

    @Override
    public Ingredient getIngredient(int idOfIng) {
        return ingredientsList.get(idOfIng);
    }

    public static Collection<Ingredient> getList() {
        return ingredientsList.values();
    }

    public static void clearList() {
        ingredientsList.clear();
    }
}
