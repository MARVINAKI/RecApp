package com.example.recapp.model;

import lombok.Data;

@Data
public class Ingredient {
    private String title;
    private double amount;
    private String unit;

    public Ingredient(String title, double amount, String unit) {
        if (title == null || title.trim().isEmpty()) {
            throw new NullPointerException();
        }
        this.title = title;
        this.amount = Math.abs(amount);
        this.unit = (unit == null || unit.trim().isEmpty()) ? null : unit;
    }
}
