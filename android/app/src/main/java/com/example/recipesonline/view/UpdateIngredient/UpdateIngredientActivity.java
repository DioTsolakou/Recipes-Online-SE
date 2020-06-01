package com.example.recipesonline.view.UpdateIngredient;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import com.example.recipesonline.R;

public class UpdateIngredientActivity extends AppCompatActivity implements UpdateIngredientView, View.OnClickListener {

    private UpdateIngredientPresenter updateIngredientPresenter;
    private Button saveBtn;
    private TableLayout existingIngredients;
    private EditText ingredientName;
    private EditText ingredientAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ingredient);

        updateIngredientPresenter = new UpdateIngredientPresenter(this);

        existingIngredients = findViewById(R.id.existingIngredientsTable);

        ingredientName = findViewById(R.id.etIngrName);
        ingredientAmount = findViewById(R.id.etIngrAmount);

        saveBtn = findViewById(R.id.saveChanges);
        saveBtn.setOnClickListener(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if (v == saveBtn) {
            //call the appropriate method for editing/updating ingredients
        }
    }
}