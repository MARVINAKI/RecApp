package com.example.recapp.model;

import lombok.Data;

import java.util.*;

@Data
public class Recipe {
    private String title;
    private int timeOfCooking;
    private Set<Ingredient> ingredients = new LinkedHashSet<>();
    private Queue<String> steps = new ArrayDeque<>();

    public Recipe(String title, int timeOfCooking, Collection<Ingredient> ingredients, Queue<String> steps) {
        this.title = title;
        this.timeOfCooking = timeOfCooking;
        this.ingredients.addAll(ingredients);
        this.steps.addAll(steps);
    }
}
