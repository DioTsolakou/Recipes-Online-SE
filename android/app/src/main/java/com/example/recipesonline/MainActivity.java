package com.example.recipesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Recipe> Recipes = new ArrayList<Recipe>();
    static HashSet<Ingredient> Ingredients = new HashSet<Ingredient>();

    public static void main(String[] args){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
