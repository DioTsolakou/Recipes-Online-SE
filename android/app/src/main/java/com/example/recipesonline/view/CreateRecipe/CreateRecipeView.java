package com.example.recipesonline.view.CreateRecipe;

import android.widget.EditText;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public interface CreateRecipeView
{
    public String getEtRecipeName();
    public void setEtRecipeName(String value);

    public TableLayout getTblIngredients();
    public void setTblIngredients(TableLayout value);

    public String getEtIngrName();
    public void setEtIngrName(String value);

    public int getEtIngrAmount();
    public void setEtIngrAmount(int value);

    public String getEtDescription();
    public void setEtDescription(String value);

    public TableLayout getTblTypes();
    public void setTblTypes(TableLayout value);
}
