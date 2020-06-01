package com.example.recipesonline.domain;

public class RecipeIngredient {
    private Ingredient ingredient;
    private double amount;

    /* Constructor */
    public RecipeIngredient(String ingredientName, double amount) {
        /* Checks if the ingredient already exists */
        for (Ingredient i : Utilities.getIngredients()) {
            if (ingredientName.equalsIgnoreCase(i.getName())) {
                this.ingredient = i;
                break;
            }
        }
        /* Creates the ingredient if it doesn't exist */
        if (ingredient == null) {
            Ingredient ingredient = new Ingredient(ingredientName);
            Utilities.getIngredients().add(ingredient);
            this.ingredient = ingredient;
        }

        this.amount = amount;
    }

    public Ingredient getIngredient() {return ingredient;}
    public double getAmount() {return amount;}

    public void setIngredient(Ingredient ingredient) {this.ingredient = ingredient;}
    public void setAmount(double amount) {this.amount = amount;}
}