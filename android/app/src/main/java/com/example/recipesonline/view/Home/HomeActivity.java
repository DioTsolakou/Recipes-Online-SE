package com.example.recipesonline.view.Home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.recipesonline.R;

public class HomeActivity extends AppCompatActivity implements HomeView{

    private EditText etSearchName;
    private EditText etIngrName;
    private EditText etCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etSearchName = findViewById(R.id.search);
        etIngrName = findViewById(R.id.etIngrName);
        etCalories = findViewById(R.id.calories);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
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
