package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private RegisteredUser user;
    private String name;
    private String description;
    private List<RecipeIngredient> ingredients;
    private List<String> types;
    private List<Evaluation> evaluationList;

    public Recipe() {}

    public Recipe(RegisteredUser user, String name, List<RecipeIngredient> ingredients, String description, List<String> types) {
        this.user = user;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.types = types;
        evaluationList = new ArrayList<Evaluation>();
    }

    public RegisteredUser getUser() {return user;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public List<RecipeIngredient> getIngredients() {return ingredients;}
    public List<String> getTypes() {return types;}
    public List<Evaluation> getEvaluationList() {return evaluationList;}

    public void setName(RegisteredUser user) {this.user = user;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setIngredients(List<RecipeIngredient> ingredients) {this.ingredients = ingredients;}
    public void setEvaluationList(List<Evaluation> evaluationList) {this.evaluationList = evaluationList;}

    public void addIngredient(RecipeIngredient ri) {ingredients.add(ri);}
    public void addEvaluation(Evaluation e) {evaluationList.add(e);}

    public double calcEvaluation() {
        double totalRatings = 0.0;
        for (Evaluation evaluation : evaluationList) {
            totalRatings += evaluation.getRating();
        }
        return totalRatings / (double) evaluationList.size();
    }

    public double calcCalories() {
        double totalCalories = 0;
        for (RecipeIngredient recipeIngredient : ingredients) {
            totalCalories += (recipeIngredient.getIngredient().getCalories()) * (recipeIngredient.getAmount() / 100.0);
        }
        return totalCalories;
    }
}