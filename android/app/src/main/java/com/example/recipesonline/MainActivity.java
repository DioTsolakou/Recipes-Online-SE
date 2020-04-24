package com.example.recipesonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Recipe> Recipes = new ArrayList<Recipe>();
    static HashSet<Ingredient> Ingredients = new HashSet<Ingredient>();
    static ArrayList<RegisteredUser> RegisteredUsers = new ArrayList<>();
    static ArrayList<RegisteredUser> LoggedInRegisteredUsers = new ArrayList<>();
    static ArrayList<Admin> Admins = new ArrayList<>();
    static ArrayList<Admin> LoggedInAdmins = new ArrayList<>();

    public static void main(String[] args) {
        Admins.add(new Admin("Dio Collaku", "admin1", "1234"));
        Admins.add(new Admin("Chara Gjergji", "admin2", "1234"));
        Admins.add(new Admin("Christos Argyropoulos", "admin3", "1234"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
        /*Scanner in = new Scanner(System.in);
        int ans;

        System.out.println("Press 0 to login");
        System.out.println("Press 1 to register");
        System.out.println("Press 2 to search");
        ans = in.nextInt();


        switch (ans) {

            case 0:
                User u = (new User()).login();
                if (u instanceof RegisteredUser) {

                    System.out.println("Press 0 to create a recipe");
                    System.out.println("Press 1 to evaluate a recipe");
                    System.out.println("Press 2 to calculate a recipe's calories");
                    System.out.println("Press 3 to logout");
                    ans = in.nextInt();

                    switch(ans){
                        case 0:
                            ((RegisteredUser) u).createRecipe();
                            break;
                        case 1:
                            ((RegisteredUser) u).evaluate();
                            break;
                        case 2:
                            ((RegisteredUser) u).calcRecipeCalories();
                            break;
                        case 3:
                            u.logout();
                            break;
                        default:
                            break;
                    }
                }

                else if(u instanceof Admin){

                    System.out.println("Press 0 to update an ingredient's calories");
                    System.out.println("Press 1 to register and admin");
                    System.out.println("Press 2 to logout");
                    ans = in.nextInt();

                    switch(ans){
                        case 0:
                            ((Admin) u).updateIngredient();
                            break;
                        case 1:
                            u.register();
                            break;
                        case 2:
                            u.logout();
                            break;
                        default:
                            break;
                    }
                }
                break;

            case 1:
                (new User()).register();
                break;

            case 2:
                for (Recipe r: (new User()).search())
                    System.out.println(r.getName());
                break;

            default:
                break;

        }*/
