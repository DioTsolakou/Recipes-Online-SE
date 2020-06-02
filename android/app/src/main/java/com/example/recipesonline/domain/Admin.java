package com.example.recipesonline.domain;

public class Admin extends User {
    private String name;
    private String username;
    private String password;

    /* Constructor */
    Admin(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {return name;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}

    public void setName(String name) {this.name = name;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}

    @Override
    public void registerUser(String name, String username, String password) {
        Utilities.getAdmins().add(new Admin(name, username, password));
    }

    @Override
    protected void logoutUser() {
        Utilities.getLoggedInAdmins().remove(this);
    }

    /* Update the existing ingredients with the appropriate name and calories */
    public void updateIngredient(String ingredientName, String correctName, int calories) {
        for (Ingredient i : Utilities.getIngredients()) {
            if (ingredientName.equalsIgnoreCase(i.getName())) {
                i.setName(correctName);
                i.setCalories(calories);
                return;
            }
        }
    }
}