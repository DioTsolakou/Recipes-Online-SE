package com.example.recipesonline.view.CreateRecipe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.recipesonline.R;

public class CreateRecipeActivity extends AppCompatActivity implements View.OnClickListener, CreateRecipeView{

    private EditText rcpName;

    private EditText rcpDescription;

    private TableLayout tblIngr;
    private EditText etIngrName;
    private EditText etIngrAmount;
    private ImageButton btnAddIngr;

    private TableLayout tblTypes;

    private Button btnUpload;
    private CreateRecipePresenter createRecipePresenter;

    private static int imgBtnCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        createRecipePresenter = new CreateRecipePresenter(this);

        rcpName = findViewById(R.id.rcpName);

        tblIngr = findViewById(R.id.tblIngredients);
        etIngrName = findViewById(R.id.etIngrName);
        etIngrAmount = findViewById(R.id.etIngrAmount);
        rcpDescription = findViewById(R.id.rcpDescription);

        tblTypes = findViewById(R.id.tblIngredients);

        btnAddIngr = findViewById(R.id.btnAddIngredient);
        btnAddIngr.setOnClickListener(this);

        btnUpload = findViewById(R.id.saveButton);
        btnUpload.setOnClickListener(this);
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
                        View row = (View)v.getParent();
                        ViewGroup container = ((ViewGroup)row.getParent());
                        container.removeView(row);
                    }
                });

                tblIngr.addView(row);
            }
        }
        if (v == btnUpload)
        {
            createRecipePresenter.onUpload();
        }
    }

    public String getEtRecipeName() {return rcpName.getText().toString().trim();}
    public void setEtRecipeName(String value) {rcpName.setText(value);}

    public TableLayout getTblIngredients() {return tblIngr;}
    public void setTblIngredients(TableLayout value) {tblIngr = value;}

    public String getEtIngrName() {return etIngrName.getText().toString().trim();}
    public void setEtIngrName(String value) {etIngrName.setText(value);}

    public int getEtIngrAmount() {return Integer.parseInt(etIngrAmount.getText().toString().trim());}
    public void setEtIngrAmount(int value) {etIngrAmount.setText(value);}

    public String getEtDescription() {return rcpDescription.getText().toString().trim();}
    public void setEtDescription(String value) {rcpDescription.setText(value);}

    public TableLayout getTblTypes() {return tblTypes;}
    public void setTblTypes(TableLayout value) {tblTypes = value;}
}