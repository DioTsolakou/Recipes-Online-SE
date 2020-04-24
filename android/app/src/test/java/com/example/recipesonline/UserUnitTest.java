package com.example.recipesonline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserUnitTest
{
    User newUser = new User();
    RegisteredUser registeredUser = new RegisteredUser("test", "test", "test");
    Admin newAdmin = new Admin("test", "test", "test");

    @Test
    public void registerTest()
    {
        newUser.register("test", "test", "test", "test");
        Assert.assertEquals(1, MainActivity.RegisteredUsers.size());
    }

    @Test
    public void loginTest()
    {
        newUser.register("test", "test", "test", "test");
        RegisteredUser rUser = (RegisteredUser)newUser.login("test", "test");
        Assert.assertEquals(1, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void logoutTest()
    {
        newUser.register("test", "test", "test", "test");
        RegisteredUser ru = (RegisteredUser) newUser.login("test", "test");
        ru.logoutUser();
        Assert.assertEquals(0, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void registerAdminTest() {

        MainActivity.Admins.add(newAdmin);
        newAdmin.register("test1", "test1", "test1", "test1");
        Assert.assertEquals(2, MainActivity.Admins.size());
    }

    @Before
    public void createRecipe(){
        newUser.register("test", "test", "test", "test");

        RegisteredUser rUser = (RegisteredUser)newUser.login("test", "test");

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


        Recipe recipe = new Recipe(registeredUser, "name", test, "desc", types);
    }
    @Test
    public void searchTest() {
    }

    @Test
    public void calcCaloriesTest()
    {
        RegisteredUser registeredUser = new RegisteredUser("test", "test", "test");

        Recipe recipe = new Recipe(registeredUser, "name", test, "desc", types);

        Assert.assertEquals(1.25, recipe.calcCalories(), 0.0);

    }
}
