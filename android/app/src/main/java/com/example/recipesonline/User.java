package com.example.recipesonline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    public User(){}

    public void register(){
        Scanner in = new Scanner(System.in);

        System.out.println("Give your name: ");
        String name = in.nextLine();

        System.out.println("Give your username: ");
        String username = in.nextLine();

        String password1, password2;
        do {
            System.out.println("Give your password: ");
            password1 = in.nextLine();

            System.out.println("Confirm your password: ");
            password2 = in.nextLine();
        } while(!password1.equals(password2));

        registerUser(name, username, password1);
    }

    public void registerUser(String name, String username, String password){
        MainActivity.RegisteredUsers.add(new RegisteredUser(name, username, password));
    }

    public User login(){
        Scanner in = new Scanner(System.in);

        System.out.println("Give the username: ");
        String username = in.nextLine();

        System.out.println("Give the password: ");
        String password = in.nextLine();

        for(Admin a: MainActivity.Admins){
            if(a.getUsername().equals(username) && a.getPassword().equals(password)) {
                System.out.println("You are logged in as " + username);
                MainActivity.LoggedInAdmins.add(a);
                return a;
            }
        }

        for(RegisteredUser ru: MainActivity.RegisteredUsers){
            if(ru.getUsername().equals(username) && ru.getPassword().equals(password)) {
                System.out.println("You are logged in as " + username);
                MainActivity.LoggedInRegisteredUsers.add(ru);
                return ru;
            }
        }

        System.out.println("Wrong credentials!");
        return null;

    }

    public User login2(String username, String password){
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

    public void logout() {
        Scanner in = new Scanner(System.in);

        System.out.println("Do you want to logout? (yes/no)");
        String ans = in.nextLine();

        if(ans.equalsIgnoreCase("yes"))
            logoutUser();
    }

    protected void logoutUser(){}

    protected List<Recipe> search(){
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        List<Recipe> result = new ArrayList<>();
        for (Recipe r: MainActivity.Recipes){
            if (r.getName().equalsIgnoreCase(name)) result.add(r);
        }
        return result;
    }

    protected List<Recipe> searchByType(){
        Scanner in = new Scanner(System.in);
        String typeName = in.nextLine();
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