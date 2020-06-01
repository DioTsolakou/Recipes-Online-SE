package com.example.recipesonline.domain;

import java.util.ArrayList;
import java.util.HashSet;

public class Utilities {

    private static User user;
    private static HashSet<Ingredient> ingredients;
    private static ArrayList<Recipe> recipes;
    private static ArrayList<RegisteredUser> registeredUsers;
    private static ArrayList<Admin> admins;

    public Utilities() {
        user = new User();
        ingredients = new HashSet<>();
        recipes = new ArrayList<>();
        registeredUsers = new ArrayList<>();
        admins = new ArrayList<>();
    }

    public static User getUser() {
        return user;
    }
    public static void setUser(User user) {
        Utilities.user = user;
    }

    public static HashSet<Ingredient> getIngredients() {
        return ingredients;
    }
    public static void setIngredients(HashSet<Ingredient> ingredients) {
        Utilities.ingredients = ingredients;
    }

    public static ArrayList<Recipe> getRecipes() {
        return recipes;
    }
    public static void setRecipes(ArrayList<Recipe> recipes) {
        Utilities.recipes = recipes;
    }

    public static ArrayList<RegisteredUser> getRegisteredUsers() {
        return registeredUsers;
    }
    public static void setRegisteredUsers(ArrayList<RegisteredUser> registeredUsers) {
        Utilities.registeredUsers = registeredUsers;
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }
    public static void setAdmins(ArrayList<Admin> admins) {
        Utilities.admins = admins;
    }

}