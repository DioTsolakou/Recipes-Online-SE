package com.example.recipesonline;

public class Evaluation {

    private static int id;
    private RegisteredUser user;
    private String comments;
    private int rating;
    private Recipe recipe;

    public Evaluation(RegisteredUser user, String comments, int rating) {
        this.user = user;
        this.comments = comments;
        this.rating = rating;
        recipe = new Recipe();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getComments()
    {
        return comments;
    }
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public int getRating()
    {
        return rating;

    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }
    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }
}
