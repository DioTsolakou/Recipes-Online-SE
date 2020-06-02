package com.example.recipesonline.view.Home;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableRow;

import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.Ingredient;
import com.example.recipesonline.domain.RecipeIngredient;
import com.example.recipesonline.domain.RegisteredUser;
import com.example.recipesonline.domain.Utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HomePresenter
{
    private HomeView view;
    private String recipeName;
    private List<String> types;
    private List<Ingredient> ingredients;
    private int calories;

    public HomePresenter(HomeView view) {
        this.view = view;
        types = new ArrayList<>();
        ingredients = new ArrayList<>();
    }

    public void onSearch()
    {
        recipeName = view.getSearchName();
        if(view.getTableIngredients().getChildCount()>= 1){
            for (int i = 1; i < view.getTableIngredients().getChildCount(); i++) {
                TableRow row = (TableRow) view.getTableIngredients().getChildAt(i);
                String name = ((EditText) (row.getChildAt(0))).getText().toString();
                ingredients.add(new Ingredient(name));
            }
        }

        for (int i = 0; i < view.getTableTypes().getChildCount(); i++){
            CheckBox cb = (CheckBox)view.getTableTypes().getChildAt(i);
            if (cb.isChecked()) types.add(cb.getText().toString());
        }

        if(Utilities.getUser() instanceof RegisteredUser){
            calories = view.getCalories();
            ((RegisteredUser)Utilities.getUser()).search(recipeName, types, ingredients, calories);
        }
        else Utilities.getUser().search(recipeName, types, ingredients);
    }
}
