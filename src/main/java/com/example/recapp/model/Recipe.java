package com.example.recapp.model;

import com.example.recapp.services.Impl.RecIngServiceImpl;
import lombok.Data;

import java.util.*;

@Data
public class Recipe {
    private String title;
    private int timeOfCooking;
    private Set<Ingredient> listOfIng = new LinkedHashSet<>();
    private Queue<String> stepsList = new ArrayDeque<>();

    public Recipe(String title, int timeOfCooking, String... steps) {
        this.title = title;
        this.timeOfCooking = timeOfCooking;
        this.listOfIng.addAll(RecIngServiceImpl.getList());
        stepsList.addAll(Arrays.asList(steps));
    }
}
