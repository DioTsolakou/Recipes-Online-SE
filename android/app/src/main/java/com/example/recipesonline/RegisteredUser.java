package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;

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

    public void createRecipe()
    {
        String name = "";
        List<RecipeIngredient> ingredients= new ArrayList<RecipeIngredient>();
        String description = "";
        //read input
        //add name, ingredients, description
        MainActivity.Recipes.add(new Recipe(this, name, ingredients, description));
    }

    public int calcCalories(String recipeName)
    {
        for (Recipe r: MainActivity.Recipes){
            if (r.getName().equals(recipeName)){
                return r.calcCalories();
            }
        }
        return -1;
    }

    public void evaluate(String recipeName)
    {
        for (Recipe r: MainActivity.Recipes){
            if (r.getName().equals(recipeName)){
                String comments = "";
                int rating = 0;
                //read input from user
                r.addEvaluation(new Evaluation(this, comments, rating));
            }
        }
    }
}