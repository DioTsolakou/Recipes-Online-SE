package com.example.recipesonline.view.Recipe;

import com.example.recipesonline.domain.Evaluation;
import com.example.recipesonline.domain.Recipe;
import com.example.recipesonline.domain.RegisteredUser;
import com.example.recipesonline.domain.Utilities;

public class RecipePresenter {

    private RecipeView view;
    private Recipe recipe;

    public RecipePresenter(RecipeView view) {
        this.view = view;
    }

    public void onSaveComment() {
        recipe.addEvaluation(new Evaluation((RegisteredUser)Utilities.getUser(), view.getComment(), view.getRating()));
    }

}
