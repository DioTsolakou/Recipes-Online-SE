package com.example.recipesonline;

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
    String getName() {return name;}
    String getDescription() {return description;}
    List<RecipeIngredient> getIngredients() {return ingredients;}
    List<String> getTypes() {return types;}
    List<Evaluation> getEvaluationList() {return evaluationList;}

    static void setCount(int c) {count = c;}
    static void clearCount() {count = 0;}
    void setId(int id) {this.id = id;}
    void setUser(RegisteredUser user) {this.user = user;}
    void setName(String name) {this.name = name;}
    void setDescription(String description) {this.description = description;}
    void setIngredients(List<RecipeIngredient> ingredients) {this.ingredients = ingredients;}
    void setEvaluationList(List<Evaluation> evaluationList) {this.evaluationList = evaluationList;}

    void addIngredient(RecipeIngredient ri) {ingredients.add(ri);}
    void addEvaluation(Evaluation e) {evaluationList.add(e);}

    /* Calculates the evaluation of a recipe */
    double calcEvaluation() {
        double totalRatings = 0.0;
        for (Evaluation evaluation : evaluationList) {
            totalRatings += evaluation.getRating();
        }
        return totalRatings / (double) evaluationList.size();
    }

    /* Calculates the calories of a recipe */
    double calcCalories() {
        double totalCalories = 0;
        for (RecipeIngredient recipeIngredient : ingredients) {
            totalCalories += (recipeIngredient.getIngredient().getCalories()) * (recipeIngredient.getAmount() / 100.0);
        }
        return totalCalories;
    }

    @Override
    public boolean equals(Object r){
        if(!(r instanceof Recipe)) return false;
        return ((Recipe)r).getId() == this.id;
    }

    @Override
    public int hashCode(){
        return id;
    }
}