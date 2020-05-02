package com.example.recipesonline;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class RegisteredUser extends User {
    private String name;
    private String username;
    private String password;

    /* Constructor */
    RegisteredUser(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    String getName() {return name;}
    String getUsername() {return username;}
    String getPassword() {return password;}

    void setName(String name) {this.name = name;}
    void setUsername(String username) {this.username = username;}
    void setPassword(String password) {this.password = password;}

    @Override
    void logoutUser() {
        MainActivity.LoggedInRegisteredUsers.remove(this);
    }

    /* Creates a recipe */
    void createRecipe(String name, List<RecipeIngredient> recipeIngredients, String description, List<String> types) {
        MainActivity.Recipes.add(new Recipe(this, name, recipeIngredients, description, types));
    }

    /* Calculates the calories of a recipe */
    double calcRecipeCalories(int recipeId) {
        for (Recipe r : MainActivity.Recipes) {
            if (r.getId() == recipeId)
                return r.calcCalories();
        }
        return -1;
    }

    /* Searches the recipe by calories */
    List<Recipe> searchByCalories(double calories) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : MainActivity.Recipes) {
            if (r.calcCalories() <= calories)  result.add(r);
        }
        return result;
    }

    /* Advanced search of User plus calories since only a registered user can calculate the calories of a recipe */
    HashSet<Recipe> search(String name, List<String> types, List<RecipeIngredient> ri, double calories){
        HashSet<Recipe> result = new HashSet<>();
        result.addAll(super.search(name, types, ri));
        if (calories > 0) result.retainAll(searchByCalories(calories));
        return result;
    }

    /* Evaluates a recipe */
    void evaluate(int recipeId, String comments, int rating) {
        for (Recipe r : MainActivity.Recipes) {
            if (r.getId() == recipeId) {
                for (Evaluation e : r.getEvaluationList())
                {
                    if (this.getUsername().equals(e.getUser().getUsername()))
                    {
                        System.out.println("You have already evaluated this recipe.");
                        return;
                    }
                }
                r.addEvaluation(new Evaluation(this, comments, rating));
                return;
            }
        }
        System.out.println("No recipe found");
    }
}