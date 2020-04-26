package com.example.recipesonline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserUnitTest
{
    User newUser = new User();
    RegisteredUser rUser;
    Admin newAdmin = new Admin("test", "test", "test");
    Recipe recipe;
    static int i=0;



    @Before
    public void createRecipeTest(){

        newUser.register("test", "test", "test", "test");
        rUser = (RegisteredUser)newUser.login("test", "test");
        i++;

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

        recipe = new Recipe(rUser, "name2", test, "desc", types);
        rUser.createRecipe("name", test, "desc", types);

    }
    @Test
    public void registerTest()
    {
            Assert.assertEquals(i, MainActivity.RegisteredUsers.size());
    }

    @Test
    public void loginTest()
    {
        Assert.assertEquals(i, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void logoutTest()
    {
        rUser.logoutUser();
        Assert.assertEquals(i-1, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void registerAdminTest() {
        MainActivity.Admins.add(newAdmin);
        newAdmin.register("test1", "test1", "test1", "test1");
        Assert.assertEquals(2, MainActivity.Admins.size());
    }

    @Test
    public void searchTest() {
        Assert.assertEquals(i, rUser.search("name").size());
    }

    @Test
    public void calcCaloriesTest()
    {
        Assert.assertEquals(1.25, recipe.calcCalories(), 0.0);
    }

    @Test
    public  void evaluateTest(){
        rUser.evaluate("name2", "testing", 5);
        Assert.assertEquals(1, recipe.getEvaluationList().size());
    }
}
