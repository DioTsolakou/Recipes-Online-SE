package com.example.recipesonline.view.Register;

import android.content.Context;
import android.content.Intent;

import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.User;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.Home.HomeActivity;
import com.example.recipesonline.view.Login.LoginPresenter;

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

        int size = Utilities.getRegisteredUsers().size();
        Utilities.getUser().register(name, username, password1, password2);
        if (Utilities.getRegisteredUsers().size() > size) {
            User u = Utilities.getUser().login(username, password1);
            Utilities.setUser(u);
        }

        Intent intent = new Intent((Context) view, HomeActivity.class);
        ((Context) view).startActivity(intent);
    }
}
