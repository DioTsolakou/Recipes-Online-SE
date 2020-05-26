package com.example.recipesonline.domain;

public class Evaluation {
    private static int count = 0;
    private int id;
    private RegisteredUser user;
    private String comments;
    private int rating;

    /* Constructor */
    public Evaluation(RegisteredUser user, String comments, int rating) {
        this.id = ++count;
        this.user = user;
        this.comments = comments;
        this.rating = rating;
    }

    public int getCount() {return count;}
    public int getId() {return id;}
    public RegisteredUser getUser() {return user;}
    public String getComments() {return comments;}
    public int getRating() {return rating;}

    public static void setCount(int c) {count = c;}
    public static void clearCount() {count = 0;}
    public void setId(int id) {this.id = id;}
    public void setUser(RegisteredUser user) {this.user = user;}
    public void setComments(String comments) {this.comments = comments;}
    public void setRating(int rating) {this.rating = rating;}
}