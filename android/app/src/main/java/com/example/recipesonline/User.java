package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;

public class User {

    public User(){}

    public void register(String name, String username, String password1, String password2 )
    {
        if(password1.equals(password2)) registerUser(name, username, password1);
    }

    public void registerUser(String name, String username, String password)
    {
        MainActivity.RegisteredUsers.add(new RegisteredUser(name, username, password));
    }

    public User login(String username, String password)
    {
        for(Admin a: MainActivity.Admins){
            if(a.getUsername().equals(username) && a.getPassword().equals(password)) {
                System.out.println("You are logged in as " + username);
                MainActivity.LoggedInAdmins.add(a);
                return a ;
            }
        }

        for(RegisteredUser ru: MainActivity.RegisteredUsers){
            if(ru.getUsername().equals(username) && ru.getPassword().equals(password)) {
                System.out.println("You are logged in as " + username);
                MainActivity.LoggedInRegisteredUsers.add(ru);
                return ru ;
            }
        }

        System.out.println("Wrong credentials!");
        return null;
    }

    public void logout(String ans)
    {
        if(ans.equalsIgnoreCase("yes"))
            logoutUser();
    }

    protected void logoutUser(){}

    protected List<Recipe> search(String name)
    {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r: MainActivity.Recipes){
            if (r.getName().equalsIgnoreCase(name)) result.add(r);
        }
        return result;
    }

    protected List<Recipe> searchByType(String typeName)
    {
        List<Recipe> result = new ArrayList<>();
        for (Recipe r: MainActivity.Recipes){
            for (String t: r.getTypes()){
                if (t.equalsIgnoreCase(typeName)){
                    result.add(r);
                    break;
                }
            }
        }
        return result;
    }
}