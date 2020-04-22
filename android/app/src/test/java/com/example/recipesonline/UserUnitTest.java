package com.example.recipesonline;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserUnitTest
{
    @Test
    public void registerTest()
    {
        User newUser = new User();
        newUser.registerUser("test", "test", "test");
        Assert.assertEquals(1, MainActivity.RegisteredUsers.size());
    }

    @Test
    public void loginTest()
    {
        User newUser = new User();
        newUser.registerUser("test", "test", "test");

        newUser.login2("test", "test");

        Assert.assertEquals(1, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void logoutTest()
    {
        User newUser = new User();
        newUser.registerUser("test", "test", "test");

        RegisteredUser ru = (RegisteredUser) newUser.login2("test", "test");

        ru.logoutUser();

        Assert.assertEquals(0, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void registerAdminTest()
    {
        Admin newAdmin = new Admin("test", "test", "test");
        MainActivity.Admins.add(newAdmin);

        newAdmin.registerUser("test1", "test1", "test1");

        Assert.assertEquals(2, MainActivity.Admins.size());
    }

    @Test
    public void searchTest()
    {
        User newUser = new User();
        newUser.registerUser("test", "test", "test");

        newUser.login2("test", "test");

    }

    @Test
    public void calcCaloriesTest()
    {
        Ingredient ingredient = new Ingredient("ingr", 100);
        Ingredient ingredient1 = new Ingredient("ingr1", 25);

        MainActivity.Ingredients.add(ingredient);
        MainActivity.Ingredients.add(ingredient1);

        RecipeIngredient recipeIngredient = new RecipeIngredient("ingr", 1, "g");
        RecipeIngredient recipeIngredient1 = new RecipeIngredient("ingr1", 1, "g");

        List<RecipeIngredient> test = new ArrayList<>();
        test.add(recipeIngredient);
        test.add(recipeIngredient1);

        String type1 = "type1";
        String type2 = "type2";
        List<String> types = new ArrayList<>();
        types.add(type1);
        types.add(type2);

        RegisteredUser registeredUser = new RegisteredUser("test", "test", "test");

        Recipe recipe = new Recipe(registeredUser, "name", test, "desc", types);

        Assert.assertEquals(1.25, recipe.calcCalories(), 0.0);

    }
}
