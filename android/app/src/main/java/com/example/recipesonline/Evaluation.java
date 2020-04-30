package com.example.recipesonline;

class Evaluation {

    private static int count = 0;
    private int id;
    private RegisteredUser user;
    private String comments;
    private int rating;

    /* Constructor */
    Evaluation(RegisteredUser user, String comments, int rating) {
        this.id = ++count;
        this.user = user;
        this.comments = comments;
        this.rating = rating;
    }

    int getCount() {return count;}
    int getId() {return id;}
    RegisteredUser getUser() {return user;}
    String getComments() {return comments;}
    int getRating() {return rating;}

    static void setCount(int c) {count = c;}
    static void clearCount() {count = 0;}
    void setId(int id) {this.id = id;}
    void setUser(RegisteredUser user) {this.user = user;}
    void setComments(String comments) {this.comments = comments;}
    void setRating(int rating) {this.rating = rating;}

}