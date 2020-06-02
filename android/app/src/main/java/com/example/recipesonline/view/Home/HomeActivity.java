package com.example.recipesonline.view.Home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.R;

public class HomeActivity extends AppCompatActivity implements HomeView, View.OnClickListener {

    private EditText etSearchName;
    private EditText etIngrName;
    private EditText etCalories;
    private ImageButton searchBtn;
    private ImageButton addIngrBtn;
    private HomePresenter homePresenter;
    private TableLayout tblIngredients;
    private TableLayout tblTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etSearchName = findViewById(R.id.search);
        etIngrName = findViewById(R.id.etIngrName);
        etCalories = findViewById(R.id.calories);
        tblIngredients = findViewById(R.id.tblIngredients);

        homePresenter = new HomePresenter(this);

        searchBtn = findViewById(R.id.btnSearch);
        searchBtn.setOnClickListener(this);

        addIngrBtn = findViewById(R.id.btnAddIngredient);
        addIngrBtn.setOnClickListener(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if (v == addIngrBtn) {
            if (etIngrName.getText().length() > 0) {
                TableRow row = new TableRow(this);

                TextView name = new TextView(this);
                name.setText(etIngrName.getText());
                row.addView(name);

                ImageButton imgBtn = new ImageButton(this);
                imgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View row = (View)v.getParent();
                        ViewGroup container = ((ViewGroup)row.getParent());
                        container.removeView(row);
                    }
                });

                tblIngredients.addView(row);
            }
        }
        if (v == searchBtn) {
            homePresenter.onSearch();
        }
    }

    public String getSearchName() {
        return etSearchName.getText().toString().trim();
    }
    public void setSearchName(String value) {
        etSearchName.setText(value);
    }

    public String getIngredientName() {
        return etIngrName.getText().toString().trim();
    }
    public void setIngredientName(String value) {
        etIngrName.setText(value);
    }

    public int getCalories() {return Integer.parseInt(etCalories.getText().toString().trim());
    }
    public void setCalories(int value) { etCalories.setText(value); }

    public TableLayout getTableIngredients() { return tblIngredients;}
    public void setTableIngredients(TableLayout value) {tblIngredients = value;}

    public TableLayout getTableTypes() { return tblTypes;}
    public void setTableTypes(TableLayout value) { tblTypes = value; }

}
