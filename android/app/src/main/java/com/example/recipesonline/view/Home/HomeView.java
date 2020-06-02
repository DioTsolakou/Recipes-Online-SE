package com.example.recipesonline.view.Home;

import android.widget.TableLayout;

public interface HomeView
{
    public String getSearchName();

    public void setSearchName(String value);

    public String getIngredientName();

    public void setIngredientName(String value);

    public int getCalories();

    public void setCalories(int value);

    public TableLayout getTableIngredients();

    public void setTableIngredients(TableLayout tableIngredients);

    public TableLayout getTableTypes();

    public void setTableTypes(TableLayout tableTypes);
}
