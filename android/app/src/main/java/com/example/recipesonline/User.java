package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;

public class User {

    protected List<Recipe> search(String name){
        List<Recipe> result = new ArrayList<>();
        for (Recipe r: MainActivity.Recipes){
            if (r.getName().equals(name)) result.add(r);
        }
        return result;
    }

    /*protected List<Recipe> searchByType(String name){
        List<Recipe> result = new ArrayList<>();
        for (Recipe r: Recipes){
            for (Type t: r.getTypes()){
                if (t.getName().equals(name)){
                    result.add(r);
                    break;
                }
            }
        }
        return result;
    }*/
}