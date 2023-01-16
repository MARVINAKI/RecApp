package com.example.recapp.model;

import lombok.Data;

import java.util.*;

@Data
public class Recipe {
    private String title;
    private int timeOfCooking;
    private Set<Ingredient> listOfIng = new LinkedHashSet<>();
    private Queue<String> stepsList = new ArrayDeque<>();

    public Recipe(String title, int timeOfCooking, Collection<Ingredient> ingredients, String... steps) {
        this.title = title;
        this.timeOfCooking = timeOfCooking;
        this.listOfIng.addAll(ingredients);
        this.stepsList.addAll(Arrays.asList(steps));
    }
}
