package com.example.recipesonline;

public class Admin extends User
{
    private String name;
    private String username;
    private String password;

    public Admin(String name, String username, String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public void registerUser(String name, String username, String password){
        MainActivity.Admins.add(new Admin(name, username, password));
    }

    @Override
    public void logoutUser(){
        MainActivity.LoggedInAdmins.remove(this);
        System.out.println("You have been logged out.");
    }

    public void updateIngredient(String ingredientName, String correctName, int calories)
    {
        for (Ingredient ingredient : MainActivity.Ingredients)
        {
            if (ingredientName.equalsIgnoreCase(ingredient.getName()))
            {
                ingredient.setName(correctName);
                ingredient.setCalories(calories);

                return;
            }
        }
    }
}