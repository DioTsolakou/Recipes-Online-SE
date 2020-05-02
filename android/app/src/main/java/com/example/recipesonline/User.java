package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;

class User {
    /* Empty constructor */
    User() {}

    /* Registers a user (as an Admin or Registered User) */
    void register(String name, String username, String password1, String password2) {
        /* Searches if the username already exists (it must be unique tο be accepted) */
        for (RegisteredUser rU : MainActivity.RegisteredUsers)
        {
            if (rU.getUsername().equals(username))
            {
                System.out.println("This username already exists.");
                return;
            }
        }

        for (Admin admin : MainActivity.Admins)
        {
            if (admin.getUsername().equals(username))
            {
                System.out.println("This username already exists.");
                return;
            }
        }

        if (password1.equals(password2))
            registerUser(name, username, password1);
    }

    void registerUser(String name, String username, String password) {
        MainActivity.RegisteredUsers.add(new RegisteredUser(name, username, password));
    }

    /* Allows to registered Users and Admins to login */
    User login(String username, String password) {
        for (Admin a : MainActivity.Admins) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                System.out.println("Welcome, " + username + "!");
                MainActivity.LoggedInAdmins.add(a);
                return a;
            }
        }

        for (RegisteredUser ru : MainActivity.RegisteredUsers) {
            if (ru.getUsername().equals(username) && ru.getPassword().equals(password)) {
                System.out.println("Welcome, " + username + "!");
                MainActivity.LoggedInRegisteredUsers.add(ru);
                return ru;
            }
        }

        System.out.println("Login failed due to wrong credentials.");
        return null;
    }

    /* Allows to logged in users to logout */
    void logout() {
        logoutUser();
        System.out.println("You have logged out.");
    }

    /* Is used for overriding */
    void logoutUser() {}

    /* Advanced search for user */
    List<Recipe> search(String name, List<String> types, List<RecipeIngredient> ri) {
        List<Recipe> r1 = new ArrayList<>();
        List<Recipe> r2 = new ArrayList<>();
        List<Recipe> r3 = new ArrayList<>();
        List<Recipe> result = new ArrayList<>();

        if (name != null) {
            r1.addAll(searchByName(name));
            result.addAll(r1);
        }
        if (types.size() > 0) {
            r2.addAll(searchByType(types));
            result.retainAll(r2);
        }
        if (ri.size() > 0) {
            r3.addAll(searchByIngredients(ri));
            result.retainAll(r3);
        }

        return result;
    }

    /* Searches the recipe by name */
    List<Recipe> searchByName(String name) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : MainActivity.Recipes) {
            if (r.getName().toLowerCase().contains(name.toLowerCase())) result.add(r);
        }
        return result;
    }

    /* Searches the recipe by their types */
    List<Recipe> searchByType(List<String> types) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : MainActivity.Recipes) {
            if (r.getTypes().containsAll(types)) {
                result.add(r);
            }
        }
        return result;
    }

    /* Searches the recipe by their ingredients */
    List<Recipe> searchByIngredients(List<RecipeIngredient> ri) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r : MainActivity.Recipes) {
            if (r.getIngredients().containsAll(ri))  result.add(r);
        }
        return result;
    }
}