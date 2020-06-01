package com.example.recipesonline.view.CreateRecipe;

import android.widget.TableRow;

import com.example.recipesonline.domain.Recipe;
import com.example.recipesonline.domain.RecipeIngredient;

import java.util.ArrayList;

public class CreateRecipePresenter
{
    private CreateRecipeView view;
    private Recipe recipe;
    private String name;
    private ArrayList<RecipeIngredient> recipeIngredients;
    private String description;
    private ArrayList<String> types;

    public CreateRecipePresenter(CreateRecipeView view) {
        this.view = view;
    }

    private void saveRecipeIngredients()
    {
        recipeIngredients = new ArrayList<>();
        for (int i = 0; i < view.getTblIngredients().getChildCount(); i++){
            TableRow row = (TableRow)view.getTblIngredients().getChildAt(i);
            recipeIngredients.add(new RecipeIngredient(row.getChildAt(0), row.getChildAt(1)));
        }
    }

    private void saveRecipeTypes()
    {

    }

    public void onUpload()
    {
        //call above methods
    }
}
