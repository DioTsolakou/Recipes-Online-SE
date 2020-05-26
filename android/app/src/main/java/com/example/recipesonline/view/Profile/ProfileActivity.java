package com.example.recipesonline.view.Profile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recipesonline.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }
}
