package main.java.com.example.recipesonline;

public class Evaluation {

    private static int id;
    private RegisteredUser user;
    private String comments;
    private int rating;

    public Evaluation(RegisteredUser user, String comments, int rating) {
        this.user = user;
        this.comments = comments;
        this.rating = rating;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}



}
