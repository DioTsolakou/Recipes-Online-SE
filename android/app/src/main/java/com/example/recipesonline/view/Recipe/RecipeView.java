package com.example.recipesonline.view.Recipe;

import android.widget.TableLayout;

public interface RecipeView {
    public String getCreator();
    public void setCreator(String value);

    public String getTotalRating();
    public void setTotalRating(double value);

    public TableLayout getIngredients();
    public void setIngredients(TableLayout tableLayout);

    public TableLayout getTypes();
    public void setTypes(TableLayout tableLayout);

    public String getDescription();
    public void setDescription(String value);

    public TableLayout getComments();
    public void setComments(TableLayout tableLayout);

    public String getComment();
    public void setComment(String value);

    public int getRating();
    public void setRating(int value);
}
