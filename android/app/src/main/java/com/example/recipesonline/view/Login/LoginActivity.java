package com.example.recipesonline.view.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.recipesonline.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private Button okBtn;
    private Button registerBtn;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);

        etUsername = findViewById(R.id.usernamePlainText);
        etPassword = findViewById(R.id.password);

        okBtn = findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(this);

        registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if (v == registerBtn) {
            loginPresenter.onRegister();
        }
        if (v == okBtn) {
            loginPresenter.onLogin();
        }
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
