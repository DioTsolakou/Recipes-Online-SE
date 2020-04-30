package com.example.recipesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    /* Declaration of the wanted lists */
    static ArrayList<Recipe> Recipes = new ArrayList<Recipe>();
    static HashSet<Ingredient> Ingredients = new HashSet<Ingredient>();
    static ArrayList<RegisteredUser> RegisteredUsers = new ArrayList<>();
    static ArrayList<RegisteredUser> LoggedInRegisteredUsers = new ArrayList<>();
    static ArrayList<Admin> Admins = new ArrayList<>();
    static ArrayList<Admin> LoggedInAdmins = new ArrayList<>();

    public static void main(String[] args) {

        /* Creating 3 administrators of the system*/
        Admins.add(new Admin("Dio Collaku", "admin1", "1234"));
        Admins.add(new Admin("Chara Gjergji", "admin2", "1234"));
        Admins.add(new Admin("Christos Argyropoulos", "admin3", "1234"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}