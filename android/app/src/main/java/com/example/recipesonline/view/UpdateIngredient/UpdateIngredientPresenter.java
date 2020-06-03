package com.example.recipesonline.view.UpdateIngredient;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.Home.HomeActivity;

public class UpdateIngredientPresenter {
    private UpdateIngredientView view;

    public UpdateIngredientPresenter(UpdateIngredientView view) {
        this.view = view;
    }

    public void onSaveChanges() {
        for (int i = 1; i < view.getIngredients().getChildCount(); i++) {

            TableRow row = (TableRow) view.getIngredients().getChildAt(i);
            String preName = ((TextView) row.getChildAt(0)).getText().toString();
            String correctName = ((EditText) row.getChildAt(1)).getText().toString();
            int calories = Integer.parseInt(((EditText) row.getChildAt(2)).getText().toString());

            ((Admin) Utilities.getUser()).updateIngredient(preName, correctName, calories);
        }

        Intent intent = new Intent((Context) view, HomeActivity.class);
        ((Context) view).startActivity(intent);
    }
}
