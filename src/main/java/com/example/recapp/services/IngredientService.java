package com.example.recapp.services;

import com.example.recapp.model.Ingredient;

import java.util.Collection;

public interface IngredientService {

    void addToList(Ingredient ingredient);

    Ingredient getIngredient(int idOfIng);

    Ingredient editIngredient(int id, Ingredient ingredient);

    boolean deleteIngredient(int id);

    Collection<Ingredient> getAllIngredients();
}
