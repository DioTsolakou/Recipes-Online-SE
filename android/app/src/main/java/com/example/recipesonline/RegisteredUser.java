package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisteredUser extends User {

    private String name;
    private String username;
    private String password;

    public RegisteredUser(String name, String username, String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void logoutUser(){
        MainActivity.LoggedInRegisteredUsers.remove(this);

        System.out.println("You have been logged out.");
    }

    public void createRecipe(String name,List<RecipeIngredient> recipeIngredients, String description, List<String> types)
    {
        MainActivity.Recipes.add(new Recipe(this, name, recipeIngredients, description, types));
    }

    public double calcRecipeCalories(String recipeName)
    {
        for (Recipe r: MainActivity.Recipes){
            if (r.getName().equalsIgnoreCase(recipeName)){
                return r.calcCalories();
            }
        }
        return -1;
    }

    public void evaluate(String recipeName, String comments, int rating)
    {
        for (Recipe r : MainActivity.Recipes){
            if (r.getName().equalsIgnoreCase(recipeName)){
                r.addEvaluation(new Evaluation(this, comments, rating));
            }
        }
    }
}