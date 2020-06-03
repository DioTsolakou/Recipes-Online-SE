package com.example.recipesonline.view.UpdateIngredient;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.R;
import com.example.recipesonline.domain.Ingredient;
import com.example.recipesonline.domain.Utilities;

public class UpdateIngredientActivity extends AppCompatActivity implements UpdateIngredientView, View.OnClickListener {

    private UpdateIngredientPresenter updateIngredientPresenter;
    private Button logoutBtn;
    private Button saveBtn;
    private TableLayout existingIngredients;
    private EditText ingredientName;
    private EditText ingredientAmount;
    private TextView txtIngredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ingredient);

        updateIngredientPresenter = new UpdateIngredientPresenter(this);

        logoutBtn = findViewById(R.id.logoutButton);
        logoutBtn.setOnClickListener(this);

        existingIngredients = findViewById(R.id.existingIngredientsTable);

        ingredientName = findViewById(R.id.etIngrName);
        ingredientAmount = findViewById(R.id.etIngrAmount);
        txtIngredient = findViewById(R.id.txtIngrName);

        saveBtn = findViewById(R.id.saveChanges);
        saveBtn.setOnClickListener(this);

        for(Ingredient i: Utilities.getIngredients()){
            TableRow row = new TableRow(this);

            TextView preName = new TextView(this);
            preName.setText(i.getName());
            row.addView(preName);

            EditText name = new EditText(this);
            name.setText(i.getName());
            row.addView(name);

            EditText calories = new EditText(this);
            calories.setText(i.getCalories());
            row.addView(calories);

            existingIngredients.addView(row);
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (Utilities.getUser() != null) {
            if ((Utilities.getLoggedInUsers().contains(Utilities.getUser()) || Utilities.getLoggedInAdmins().contains(Utilities.getUser())))
                logoutBtn.setVisibility(View.VISIBLE);
            else
                logoutBtn.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == saveBtn) {
            updateIngredientPresenter.onSaveChanges();
        }
        if (v == logoutBtn) {
            updateIngredientPresenter.onLogout();
            finish();
            startActivity(getIntent());
        }
    }

    public TableLayout getIngredients(){ return existingIngredients; }
    public void setIngredients(TableLayout value){ existingIngredients = value; }
}