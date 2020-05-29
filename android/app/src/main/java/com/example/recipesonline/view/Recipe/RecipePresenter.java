package com.example.recipesonline.view.Recipe;

import com.example.recipesonline.domain.Recipe;

public class RecipePresenter {
    private RecipeView view;
    private Recipe recipe;

    public RecipePresenter(RecipeView view) {
        this.view = view;
    }
}
