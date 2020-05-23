package com.example.recipesonline;

public class RecipeIngredient {
    private Ingredient ingredient;
    private double amount;
    private String metricUnit;

    /* Constructor */
    public RecipeIngredient(String ingredientName, double amount, String metricUnit) {
        /* Checks if the ingredient already exists */
        for (Ingredient i : MainActivity.Ingredients) {
            if (ingredientName.equalsIgnoreCase(i.getName())) {
                this.ingredient = i;
                break;
            }
        }
        /* Creates the ingredient if it doesn't exist */
        if (ingredient == null) {
            Ingredient ingredient = new Ingredient(ingredientName);
            MainActivity.Ingredients.add(ingredient);
            this.ingredient = ingredient;
        }

        this.amount = amount;
        this.metricUnit = metricUnit;
    }

    public Ingredient getIngredient() {return ingredient;}
    public double getAmount() {return amount;}
    public String getMetricUnit() {return metricUnit;}

    public void setIngredient(Ingredient ingredient) {this.ingredient = ingredient;}
    public void setAmount(double amount) {this.amount = amount;}
    public void setMetricUnit(String metricUnit) {this.metricUnit = metricUnit;}
}