package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private RegisteredUser user;
    private String name;
    private String description;
    private String id;
    private List<RecipeIngredient> ingredients;
    private List<Evaluation> evaluationList;
    //private List<Type> types;

    public Recipe(){}

    public Recipe(RegisteredUser user, String name, List<RecipeIngredient> ingredients, String description)
    {
        this.user = user;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        evaluationList = new ArrayList<Evaluation>();
    }

    public Recipe(RegisteredUser user, String name, List<RecipeIngredient> ingredients, String description, String id)
    {
        this(user, name, ingredients, description);
        this.id = id;
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public int calcCalories()
    {
        int totalCalories = 0;
        for (RecipeIngredient recipeIngredient : ingredients)
        {
            totalCalories += (recipeIngredient.getIngredient().getCalories()) * (recipeIngredient.getAmount() / 100.0);
        }

        return totalCalories;
    }
}