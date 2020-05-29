package com.example.recipesonline.view.Register;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.recipesonline.R;

public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener {

    private EditText etName;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPasswordConfirmation;
    private Button okBtn;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerPresenter = new RegisterPresenter(this);

        etName = findViewById(R.id.namePlainText);
        etUsername = findViewById(R.id.usernamePlainText);
        etPassword = findViewById(R.id.passwordPlainText);
        etPasswordConfirmation = findViewById(R.id.confirmPasswordPlainText);

        okBtn = findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if (v == okBtn) {
            registerPresenter.onSignUp();
        }
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
