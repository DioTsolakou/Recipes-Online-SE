package com.example.recipesonline.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.R;

public class CreateRecipeActivity extends AppCompatActivity implements View.OnClickListener {

    private TableLayout tblIngr;

    private EditText etIngrName;
    private EditText etIngrAmount;
    private ImageButton btnAddIngr;

    private static int imgBtnCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        tblIngr = findViewById(R.id.tblIngredients);

        etIngrName = findViewById(R.id.etIngrName);
        etIngrAmount = findViewById(R.id.etIngrAmount);
        btnAddIngr = findViewById(R.id.btnAddIngredient);
        btnAddIngr.setOnClickListener(this);

    }

    @Override
    public void onClick (View v) {
        if (v == btnAddIngr) {
            if (etIngrName.getText().length() > 0 && etIngrAmount.getText().length() > 0) {

                TableRow row = new TableRow(this);

                TextView name = new TextView(this);
                name.setText(etIngrName.getText());
                row.addView(name);

                TextView amount = new TextView(this);
                amount.setText(etIngrAmount.getText());
                row.addView(amount);

                ImageButton imgBtn = new ImageButton(this);
                imgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tblIngr.removeView(row);
                    }
                });
                //++imgBtnCounter;
                //imgBtn.setId(imgBtnCounter);

                tblIngr.addView(row);
            }
        }

    }


}
