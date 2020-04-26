package com.example.recipesonline;

class RecipeIngredient {

    private Ingredient ingredient;
    private double amount;
    private String metricUnit;

    RecipeIngredient(String ingredientName, double amount, String metricUnit) {
        for (Ingredient ingredient : MainActivity.Ingredients) {
            if (ingredientName.equalsIgnoreCase(ingredient.getName())) {
                this.ingredient = ingredient;
                break;
            }
        }

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