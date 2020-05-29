package com.example.recipesonline.view.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.recipesonline.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.usernamePlainText);
        etPassword = findViewById(R.id.password);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public void setUsername(String value) {
        etUsername.setText(value);
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void setPassword(String value) {
        etPassword.setText(value);
    }
}
