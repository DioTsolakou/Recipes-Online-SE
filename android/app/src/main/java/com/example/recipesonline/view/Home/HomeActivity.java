package com.example.recipesonline.view.Home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recipesonline.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }
}