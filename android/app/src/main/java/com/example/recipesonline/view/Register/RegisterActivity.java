package com.example.recipesonline.view.Register;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.example.recipesonline.R;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private EditText etName;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPasswordConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.namePlainText);
        etUsername = findViewById(R.id.usernamePlainText);
        etPassword = findViewById(R.id.passwordPlainText);
        etPasswordConfirmation = findViewById(R.id.confirmPasswordPlainText);
    }


    @Override
    public String getNamePlaintext() {
        return etName.getText().toString().trim();
    }

    @Override
    public void setNamePlaintext(String value) {
        etName.setText(value);
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

    @Override
    public String getPasswordConfirmation() {
        return etPasswordConfirmation.getText().toString().trim();
    }

    @Override
    public void setPasswordConfirmation(String value) {
        etPasswordConfirmation.setText(value);
    }
}
