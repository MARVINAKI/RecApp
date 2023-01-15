package com.example.recapp.services;

import com.example.recapp.model.Recipe;

public interface RecService {

    void addRecipe(Recipe recipe);

    Recipe getRecipe(int idOfRec);
}
