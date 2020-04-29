package com.example.recipesonline;

class Admin extends User {
    private String name;
    private String username;
    private String password;

    Admin(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    String getName() {return name;}
    String getUsername() {return username;}
    String getPassword() {return password;}

    void setName(String name) {this.name = name;}
    void setUsername(String username) {this.username = username;}
    void setPassword(String password) {this.password = password;}

    @Override
    void registerUser(String name, String username, String password) {
        MainActivity.Admins.add(new Admin(name, username, password));
    }

    @Override
    void logoutUser() {
        MainActivity.LoggedInAdmins.remove(this);
    }

    void updateIngredient(String ingredientName, String correctName, int calories) {
        for (Ingredient i : MainActivity.Ingredients) {
            if (ingredientName.equalsIgnoreCase(i.getName())) {
                i.setName(correctName);
                i.setCalories(calories);
                return;
            }
        }
    }

}