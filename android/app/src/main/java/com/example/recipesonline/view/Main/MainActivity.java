package com.example.recipesonline.view.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.Home.HomeActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilities utilities = new Utilities();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
