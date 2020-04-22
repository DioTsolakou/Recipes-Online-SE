package com.example.recipesonline;

import java.util.Scanner;

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
    }

    public void updateIngredient()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the name of the ingredient you would like to update : ");
        String ingredientName = in.nextLine();

        for (Ingredient ingredient : MainActivity.Ingredients)
        {
            if (ingredientName.equalsIgnoreCase(ingredient.getName()))
            {
                System.out.println("Enter the name of the ingredient : ");
                ingredient.setName(in.nextLine());

                System.out.println("Enter the calories of the ingredient : ");
                ingredient.setCalories(Integer.parseInt(in.nextLine()));

                break;
            }
        }
    }
}