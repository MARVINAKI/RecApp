package com.example.recapp.services;

import com.example.recapp.model.Ingredient;

public interface IngService {

    void addToList(Ingredient ingredient);

    Ingredient getIngredient(int idOfIng);
}
