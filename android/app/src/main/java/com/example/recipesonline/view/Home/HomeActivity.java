package com.example.recipesonline.view.Home;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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
import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.RegisteredUser;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.CreateRecipe.CreateRecipeActivity;
import com.example.recipesonline.view.Login.LoginActivity;
import com.example.recipesonline.view.UpdateIngredient.UpdateIngredientActivity;

public class HomeActivity extends AppCompatActivity implements HomeView, View.OnClickListener {

    private EditText etSearchName;
    private EditText etIngrName;
    private EditText etCalories;
    private Button searchBtn;
    private Button addIngrBtn;
    private Button updateIngrBtn;
    private Button loginBtn;
    private Button logoutBtn;
    private Button createYourRecipeBtn;
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

        updateIngrBtn = findViewById(R.id.updateIngrButton);
        updateIngrBtn.setOnClickListener(this);

        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(this);

        logoutBtn = findViewById(R.id.logoutButton);
        logoutBtn.setOnClickListener(this);

        createYourRecipeBtn = findViewById(R.id.createYourRecipe);
        createYourRecipeBtn.setOnClickListener(this);
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
        if (!(Utilities.getUser() instanceof Admin)) {
            updateIngrBtn.setVisibility(View.INVISIBLE);
        }

        if (Utilities.getUser() != null) {
            if ((Utilities.getLoggedInUsers().contains(Utilities.getUser()) || Utilities.getLoggedInAdmins().contains(Utilities.getUser())))
            {
                loginBtn.setVisibility(View.INVISIBLE);
                logoutBtn.setVisibility(View.VISIBLE);
            }
            else {
                loginBtn.setVisibility(View.VISIBLE);
                logoutBtn.setVisibility(View.INVISIBLE);
                etCalories.setVisibility(View.GONE);
            }
        }

        if(!(Utilities.getUser() instanceof RegisteredUser)){
            createYourRecipeBtn.setVisibility(View.INVISIBLE);
        }
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
        if (v == updateIngrBtn) {
            Intent intent = new Intent(HomeActivity.this, UpdateIngredientActivity.class);
            startActivity(intent);
        }
        if (v == loginBtn) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (v == logoutBtn) {
            homePresenter.onLogout();
            finish();
            startActivity(getIntent());
        }
        if (v == createYourRecipeBtn) {
            Intent intent = new Intent(HomeActivity.this, CreateRecipeActivity.class);
            startActivity(intent);
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
