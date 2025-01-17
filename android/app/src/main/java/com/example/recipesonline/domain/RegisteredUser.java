package com.example.recipesonline.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RegisteredUser extends User {
    private String name;
    private String username;
    private String password;

    /* Constructor */
    RegisteredUser(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {return name;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}

    public void setName(String name) {this.name = name;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}

    @Override
    protected void logoutUser() {
        Utilities.getLoggedInUsers().remove(this);
    }

    /* Creates a recipe */
    public void createRecipe(String name, List<RecipeIngredient> recipeIngredients, String description, List<String> types) {
        Utilities.getRecipes().add(new Recipe(this, name, recipeIngredients, description, types));
    }

    /* Calculates the calories of a recipe */
    public double calcRecipeCalories(int recipeId) {
        for (Recipe r : Utilities.getRecipes()) {
            if (r.getId() == recipeId)
                return r.calcCalories();
        }
        return -1;
    }

    /* Searches the recipe by calories */
    public List<Recipe> searchByCalories(double calories) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : Utilities.getRecipes()) {
            if (r.calcCalories() <= calories)  result.add(r);
        }
        return result;
    }

    /* Advanced search of User plus calories since only a registered user can calculate the calories of a recipe */
    public HashSet<Recipe> search(String name, List<String> types, List<Ingredient> ri, double calories){
        HashSet<Recipe> result = new HashSet<>();
        result.addAll(super.search(name, types, ri));
        if (calories > 0) result.retainAll(searchByCalories(calories));
        return result;
    }

    /* Evaluates a recipe */
    public void evaluate(int recipeId, String comments, int rating) {
        for (Recipe r : Utilities.getRecipes()) {
            if (r.getId() == recipeId) {
                for (Evaluation e : r.getEvaluationList())
                {
                    if (this.getUsername().equals(e.getUser().getUsername()))
                    {
                        //System.out.println("You have already evaluated this recipe.");
                        return;
                    }
                }
                r.addEvaluation(new Evaluation(this, comments, rating));
                return;
            }
        }
        //System.out.println("No recipe found");
    }
}