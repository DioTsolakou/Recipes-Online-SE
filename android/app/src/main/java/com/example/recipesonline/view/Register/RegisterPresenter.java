package com.example.recipesonline.view.Register;

import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.Utilities;

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
    }
}
