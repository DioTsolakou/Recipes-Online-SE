package com.example.recipesonline.domain;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private static int count = 0;
    private int id;
    private RegisteredUser user;
    private String name;
    private String description;
    private List<RecipeIngredient> ingredients;
    private List<String> types;
    private List<Evaluation> evaluationList;

    /* Constructor */
    public Recipe(RegisteredUser user, String name, List<RecipeIngredient> recipeIngredients, String description, List<String> types) {
        this.id = ++count;
        this.user = user;
        this.name = name;
        this.description = description;
        this.ingredients = recipeIngredients;
        this.types = types;
        evaluationList = new ArrayList<Evaluation>();
    }

    public static int getCount() {return count;}
    public int getId() {return id;}
    public RegisteredUser getUser() {return user;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public List<RecipeIngredient> getIngredients() {return ingredients;}
    public List<String> getTypes() {return types;}
    public List<Evaluation> getEvaluationList() {return evaluationList;}

    public static void setCount(int c) {count = c;}
    public static void clearCount() {count = 0;}
    public void setId(int id) {this.id = id;}
    public void setUser(RegisteredUser user) {this.user = user;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setIngredients(List<RecipeIngredient> ingredients) {this.ingredients = ingredients;}
    public void setEvaluationList(List<Evaluation> evaluationList) {this.evaluationList = evaluationList;}

    public void addIngredient(RecipeIngredient ri) {ingredients.add(ri);}
    public void addEvaluation(Evaluation e) {evaluationList.add(e);}

    /* Calculates the evaluation of a recipe */
    public double calcEvaluation() {
        double totalRatings = 0.0;
        for (Evaluation evaluation : evaluationList) {
            totalRatings += evaluation.getRating();
        }
        return totalRatings / (double) evaluationList.size();
    }

    /* Calculates the calories of a recipe */
    public double calcCalories() {
        double totalCalories = 0;
        for (RecipeIngredient recipeIngredient : ingredients) {
            totalCalories += (recipeIngredient.getIngredient().getCalories()) * (recipeIngredient.getAmount() / 100.0);
        }
        return totalCalories;
    }

    @Override
    public boolean equals(Object r){
        if (!(r instanceof Recipe)) return false;
        return ((Recipe)r).getId() == this.id;
    }

    @Override
    public int hashCode(){
        return id;
    }
}