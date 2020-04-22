package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private RegisteredUser user;
    private String name;
    private String description;
    private List<RecipeIngredient> ingredients;
    private List<Evaluation> evaluationList;
    private List<String> types;

    public Recipe(){}

    public Recipe(RegisteredUser user, String name, List<RecipeIngredient> ingredients, String description, List<String> types)
    {
        this.user = user;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        evaluationList = new ArrayList<Evaluation>();
        this.types = types;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<RecipeIngredient> getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients)
    {
        this.ingredients = ingredients;
    }

    public List<Evaluation> getEvaluationList()
    {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList)
    {
        this.evaluationList = evaluationList;
    }

    public List<String> getTypes() {
        return types;
    }

    public void addIngredient(RecipeIngredient ri)
    {
        ingredients.add(ri);
    }

    public void addEvaluation(Evaluation e)
    {
        evaluationList.add(e);
    }

    public double calcEvaluation()
    {
        double totalRatings = 0.0;
        for (Evaluation evaluation : evaluationList)
        {
            totalRatings += evaluation.getRating();
        }

        return totalRatings / (double) evaluationList.size();
    }

    public double calcCalories()
    {
        double totalCalories = 0;
        for (RecipeIngredient recipeIngredient : ingredients)
        {
            totalCalories += (recipeIngredient.getIngredient().getCalories()) * (recipeIngredient.getAmount() / 100.0);
        }

        return totalCalories;
    }
}