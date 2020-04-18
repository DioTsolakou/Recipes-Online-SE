package com.example.recipesonline;

public class RecipeIngredient {

    Ingredient ingredient;
    double amount;
    String metricUnit;

    public RecipeIngredient(Ingredient ingredient, double amount, String metricUnit)
    {
        this.ingredient = ingredient;
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