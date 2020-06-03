package com.example.recipesonline.view.CreateRecipe;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.domain.Recipe;
import com.example.recipesonline.domain.RecipeIngredient;
import com.example.recipesonline.domain.RegisteredUser;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.Home.HomeActivity;
import com.example.recipesonline.view.Recipe.RecipeActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateRecipePresenter
{
    private CreateRecipeView view;
    private Recipe recipe;
    private String name;
    private ArrayList<RecipeIngredient> recipeIngredients;
    private String description;
    private ArrayList<String> types;

    public CreateRecipePresenter(CreateRecipeView view) { this.view = view; }

    private void saveRecipeIngredients()
    {
        recipeIngredients = new ArrayList<>();
        if(view.getTblIngredients().getChildCount()<= 1) return;
        for (int i = 1; i < view.getTblIngredients().getChildCount(); i++) {
            TableRow row = (TableRow)view.getTblIngredients().getChildAt(i);
            String name = ((EditText)(row.getChildAt(0))).getText().toString();
            double amount = Double.parseDouble(((EditText)(row.getChildAt(1))).getText().toString());
            recipeIngredients.add(new RecipeIngredient(name, amount));
        }
    }

    private void saveRecipeTypes()
    {
        types = new ArrayList<>();
        for (int i = 0; i < view.getTblTypes().getChildCount(); i++) {
            CheckBox cb = (CheckBox)view.getTblTypes().getChildAt(i);
            if (cb.isChecked()) types.add(cb.getText().toString());
        }
    }

    public void onUpload()
    {
        name = view.getEtRecipeName();
        saveRecipeIngredients();
        description = view.getEtDescription();
        saveRecipeTypes();
        recipe = new Recipe((RegisteredUser)Utilities.getUser(), name, recipeIngredients, description, types);

        Intent intent = new Intent((Context) view, HomeActivity.class);
        ((Context) view).startActivity(intent);
    }
}
