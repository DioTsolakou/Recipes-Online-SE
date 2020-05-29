package com.example.recipesonline.view.Recipe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.recipesonline.R;

public class RecipeActivity extends AppCompatActivity implements RecipeView{

    private TableLayout tblIngredients;
    private TableLayout tblTypes;
    private TableLayout tblComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        tblIngredients = findViewById(R.id.tblIngredients);
        tblTypes = findViewById(R.id.tblTypes);
        tblComments = findViewById(R.id.tblComments);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public TableLayout getIngredients() {
        return tblIngredients;
    }

    @Override
    public void setIngredients(TableLayout tableLayout) {
        tblIngredients = tableLayout;
    }

    @Override
    public TableLayout getTypes() {

        return tblTypes;
    }

    @Override
    public void setTypes(TableLayout tableLayout) {
        tblTypes = tableLayout;
    }

    @Override
    public TableLayout getComments() {

        return tblComments;
    }

    @Override
    public void setComments(TableLayout tableLayout) {
        tblComments = tableLayout;
    }
}
