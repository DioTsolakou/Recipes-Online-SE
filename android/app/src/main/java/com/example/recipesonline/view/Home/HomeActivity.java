package com.example.recipesonline.view.Home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.recipesonline.R;

public class HomeActivity extends AppCompatActivity implements HomeView, View.OnClickListener {

    private EditText etSearchName;
    private EditText etIngrName;
    private EditText etCalories;
    private ImageButton searchBtn;
    private ImageButton addIngrBtn;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etSearchName = findViewById(R.id.search);
        etIngrName = findViewById(R.id.etIngrName);
        etCalories = findViewById(R.id.calories);

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

        }
        if (v == searchBtn) {
            homePresenter.onSearch();
        }
    }

    @Override
    public String getSearchName() {
        return etSearchName.getText().toString().trim();
    }

    @Override
    public void setSearchName(String value) {
        etSearchName.setText(value);
    }

    @Override
    public String getIngredientName() {
        return etIngrName.getText().toString().trim();
    }

    @Override
    public void setIngredientName(String value) {
        etIngrName.setText(value);
    }

    @Override
    public int getCalories() {
        return Integer.parseInt(etCalories.getText().toString().trim());
    }

    @Override
    public void setCalories(int value) {
        etCalories.setText(value);
    }
}
