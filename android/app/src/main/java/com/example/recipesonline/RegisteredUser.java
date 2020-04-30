package com.example.recipesonline;

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

    double calcRecipeCalories(int recipeId) {
        for (Recipe r : MainActivity.Recipes) {
            if (r.getId() == recipeId)
                return r.calcCalories();
        }
        return -1;
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