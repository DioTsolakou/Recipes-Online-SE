package com.example.recipesonline.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {
    /* Empty constructor */
    User() {}

    /* Registers a user (as an Admin or Registered User) */
    public void register(String name, String username, String password1, String password2) {
        /* Searches if the username already exists (it must be unique tο be accepted) */
        for (RegisteredUser rU : Utilities.getRegisteredUsers())
        {
            if (rU.getUsername().equals(username))
            {
                //System.out.println("This username already exists.");
                return;
            }
        }

        for (Admin admin : Utilities.getAdmins())
        {
            if (admin.getUsername().equals(username))
            {
                //System.out.println("This username already exists.");
                return;
            }
        }

        if (password1.equals(password2))
            registerUser(name, username, password1);
    }

    public void registerUser(String name, String username, String password) {
        Utilities.getRegisteredUsers().add(new RegisteredUser(name, username, password));
    }

    /* Allows to registered Users and Admins to login */
    public User login(String username, String password) {
        for (Admin a : Utilities.getAdmins()) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                //System.out.println("Welcome, " + username + "!");
                Utilities.getLoggedInAdmins().add(a);
                return a;
            }
        }

        for (RegisteredUser ru : Utilities.getRegisteredUsers()) {
            if (ru.getUsername().equals(username) && ru.getPassword().equals(password)) {
                //System.out.println("Welcome, " + username + "!");
                Utilities.getLoggedInUsers().add(ru);
                return ru;
            }
        }

        //System.out.println("Login failed due to wrong credentials.");
        return null;
    }

    /* Allows to logged in users to logout */
    public void logout() {
        logoutUser();
        //System.out.println("You have logged out.");
    }

    /* Is used for overriding */
    protected void logoutUser() {}

    /* Advanced search for user */
    public HashSet<Recipe> search(String name, List<String> types, List<Ingredient> ri) {
        HashSet<Recipe> rtemp = new HashSet<>();
        HashSet<Recipe> result = new HashSet<>(Utilities.getRecipes());

        if (name != null) {
            rtemp.addAll(searchByName(name));
            result.retainAll(rtemp);
        }
        if (types.size() > 0) {
            rtemp.addAll(searchByType(types));
            result.retainAll(rtemp);
        }
        if (ri.size() > 0) {
            rtemp.addAll(searchByIngredients(ri));
            result.retainAll(rtemp);
        }

        return result;
    }

    /* Searches the recipe by name */
    public List<Recipe> searchByName(String name) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : Utilities.getRecipes()) {
            if (r.getName().toLowerCase().contains(name.toLowerCase())) result.add(r);
        }
        return result;
    }

    /* Searches the recipe by their types */
    public List<Recipe> searchByType(List<String> types) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : Utilities.getRecipes()) {
            if (r.getTypes().containsAll(types)) {
                result.add(r);
            }
        }
        return result;
    }

    /* Searches the recipe by their ingredients */
    public List<Recipe> searchByIngredients(List<Ingredient> ri) {
        List<Recipe> result = new ArrayList<>();
        outerloop:for (Recipe r: Utilities.getRecipes()) {
            for(RecipeIngredient rIng: r.getIngredients()){
                if (!ri.contains(rIng)) continue outerloop;
            }
            result.add(r);
        }
        return result;
    }
}