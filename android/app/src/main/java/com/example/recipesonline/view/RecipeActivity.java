package com.example.recipesonline.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recipesonline.R;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }
}