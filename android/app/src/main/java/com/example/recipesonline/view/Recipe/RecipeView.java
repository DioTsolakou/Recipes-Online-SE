package com.example.recipesonline.view.Recipe;

import android.widget.TableLayout;

public interface RecipeView {
    public TableLayout getIngredients();

    public void setIngredients(TableLayout tableLayout);

    public TableLayout getTypes();

    public void setTypes(TableLayout tableLayout);

    public TableLayout getComments();

    public void setComments(TableLayout tableLayout);
}
