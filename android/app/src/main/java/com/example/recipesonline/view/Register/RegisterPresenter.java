package com.example.recipesonline.view.Register;

import android.content.Context;
import android.content.Intent;

import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.Home.HomeActivity;

public class RegisterPresenter {

    private RegisterView view;
    private String name;
    private String username;
    private String password1;
    private String password2;

    public RegisterPresenter(RegisterView view) {
        this.view = view;
    }

    public void onSignUp()
    {
        name = view.getNamePlaintext();
        username = view.getUsername();
        password1 = view.getPassword();
        password2 = view.getPasswordConfirmation();

        Utilities.getUser().register(name, username, password1, password2);

        Intent intent = new Intent((Context) view, HomeActivity.class);
        ((Context) view).startActivity(intent);
    }
}
