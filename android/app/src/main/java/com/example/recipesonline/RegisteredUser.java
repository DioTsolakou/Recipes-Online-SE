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

    public void createRecipe()
    {
        Scanner in = new Scanner(System.in);
        String name;
        List<RecipeIngredient> recipeIngredients = new ArrayList<RecipeIngredient>();
        String description;
        String parsing;
        String ingredientName;
        double amount;
        String metricUnit;

        //read input
        System.out.println("Give the name of the recipe : ");
        name = in.nextLine();

        System.out.println("Give the ingredients of the recipe. Please separate each ingredient with its amount and its metric unit with a comma : ");
        System.out.println("Type exit if you are done.");
        while (true)
        {
            parsing = in.nextLine();
            if (parsing.equalsIgnoreCase("exit"))
            {
                break;
            }
            ingredientName = parsing.substring(0, parsing.indexOf(','));
            amount = Double.parseDouble(parsing.substring(parsing.indexOf(',') + 1));
            metricUnit = parsing.substring(parsing.lastIndexOf(',') + 1);

            RecipeIngredient newRecipeIngredient = new RecipeIngredient(ingredientName, amount, metricUnit);
            recipeIngredients.add(newRecipeIngredient);
        }

        System.out.println("Give the description of the recipe : ");
        description = in.nextLine();

        //add name, ingredients, description
        MainActivity.Recipes.add(new Recipe(this, name, recipeIngredients, description));
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
        for (Recipe r : MainActivity.Recipes){
            if (r.getName().equals(recipeName)){
                String comments = "";
                int rating = 0;
                //read input from user
                r.addEvaluation(new Evaluation(this, comments, rating));
            }
        }
    }
}