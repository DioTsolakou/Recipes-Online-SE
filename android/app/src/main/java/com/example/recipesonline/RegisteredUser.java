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

        System.out.println("Give the types of the recipe");
        System.out.println("Type exit if you are done.");
        List<String> types = new ArrayList<String>();
        while(true) {
            String type = in.nextLine();
            if(type.equalsIgnoreCase("exit")) break;
            types.add(type);
        }

        MainActivity.Recipes.add(new Recipe(this, name, recipeIngredients, description, types));
    }

    public double calcRecipeCalories()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the recipe which calories' you would like to calculate : ");
        String recipeName = in.nextLine();

        for (Recipe r: MainActivity.Recipes){
            if (r.getName().equalsIgnoreCase(recipeName)){
                return r.calcCalories();
            }
        }
        return -1;
    }

    public void evaluate()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the name of the recipe you would like to evaluate : ");
        String recipeName = in.nextLine();

        for (Recipe r : MainActivity.Recipes){
            if (r.getName().equalsIgnoreCase(recipeName)){
                String comments;
                int rating;

                //read input from user
                System.out.println("Insert the comments you would like to leave : ");
                comments = in.nextLine();

                System.out.println("Insert the rating for this recipe : ");
                rating = Integer.parseInt(in.nextLine());

                r.addEvaluation(new Evaluation(this, comments, rating));
            }
        }
    }
}