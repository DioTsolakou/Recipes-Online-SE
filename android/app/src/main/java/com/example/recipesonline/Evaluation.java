package com.example.recipesonline;

class Evaluation {

    private static int id;
    private RegisteredUser user;
    private String comments;
    private int rating;

    Evaluation(RegisteredUser user, String comments, int rating) {
        this.user = user;
        this.comments = comments;
        this.rating = rating;
    }

    int getId() {return id;}
    RegisteredUser getUser() {return user;}
    String getComments() {return comments;}
    int getRating() {return rating;}

    void setId(int id) {this.id = id;}
    void setUser(RegisteredUser user) {this.user = user;}
    void setComments(String comments) {this.comments = comments;}
    void setRating(int rating) {this.rating = rating;}

}