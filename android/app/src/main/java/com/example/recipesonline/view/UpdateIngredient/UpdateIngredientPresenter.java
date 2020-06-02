package com.example.recipesonline.view.UpdateIngredient;

import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.Utilities;

public class UpdateIngredientPresenter {
    private UpdateIngredientView view;

    public UpdateIngredientPresenter(UpdateIngredientView view) {
        this.view = view;
    }

    public void onSaveChanges()
    {
        if(Utilities.getUser() instanceof Admin){
            for(int i=1; i<view.getIngredients().getChildCount(); i++){

                TableRow row = (TableRow) view.getIngredients().getChildAt(i);
                String preName = ((TextView)row.getChildAt(0)).getText().toString();
                String correctName =  ((EditText)row.getChildAt(1)).getText().toString();
                int calories = Integer.parseInt(((EditText)row.getChildAt(2)).getText().toString());

                ((Admin) Utilities.getUser()).updateIngredient(preName, correctName, calories);
            }
        }
    }
}
