package com.example.recipesonline;

class RecipeIngredient {

    private Ingredient ingredient;
    private double amount;
    private String metricUnit;

    /* Constructor */
    RecipeIngredient(String ingredientName, double amount, String metricUnit) {
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

    Ingredient getIngredient() {return ingredient;}
    double getAmount() {return amount;}
    String getMetricUnit() {return metricUnit;}

    void setIngredient(Ingredient ingredient) {this.ingredient = ingredient;}
    void setAmount(double amount) {this.amount = amount;}
    void setMetricUnit(String metricUnit) {this.metricUnit = metricUnit;}

}