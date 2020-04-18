package com.example.recipesonline;

public class RecipeIngredient {

    Ingredient ingredient;
    double amount;
    String metricUnit;

    public RecipeIngredient(String ingredientName, double amount, String metricUnit)
    {
        for (Ingredient ingredient : MainActivity.Ingredients)
        {
            if (ingredientName.equalsIgnoreCase(ingredient.getName()))
            {
                this.ingredient = ingredient;
                break;
            }
        }

        if (ingredient == null)
        {
            Ingredient ingredient = new Ingredient(ingredientName);
            MainActivity.Ingredients.add(ingredient);
            this.ingredient = ingredient;
        }

        this.amount = amount;
        this.metricUnit = metricUnit;
    }

    public Ingredient getIngredient()
    {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient)
    {
        this.ingredient = ingredient;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getMetricUnit()
    {
        return metricUnit;
    }

    public void setMetricUnit(String metricUnit)
    {
        this.metricUnit = metricUnit;
    }
}