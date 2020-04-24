package com.example.recipesonline;

public class Ingredient {

    private String name;
    private int calories;

    public Ingredient(String name) {
        this.name = name;
        this.calories = 0;
    }

    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {return name;}
    public int getCalories() {return calories;}

    public void setName(String name) {this.name = name;}
    public void setCalories(int calories) {this.calories = calories;}

}