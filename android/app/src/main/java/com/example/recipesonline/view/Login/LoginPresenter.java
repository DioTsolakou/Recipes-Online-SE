package com.example.recipesonline.view.Login;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.recipesonline.domain.User;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.Home.HomeActivity;
import com.example.recipesonline.view.Register.RegisterActivity;

public class LoginPresenter {

    private LoginView view;
    private String username;
    private String password;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void onLogin()
    {
        username = view.getUsername();
        password = view.getPassword();
        User u = Utilities.getUser().login(username, password);
        if (u != null){
            Utilities.setUser(u);
            Intent intent = new Intent((Context)view, HomeActivity.class);
            ((Context) view).startActivity(intent);
        }
        else
            Toast.makeText((Context)view, "Wrong credentials!", Toast.LENGTH_SHORT).show();
    }

    public void onRegister()
    {
        Intent intent = new Intent((Context)view, RegisterActivity.class);
        ((Context)view).startActivity(intent);
    }
}
