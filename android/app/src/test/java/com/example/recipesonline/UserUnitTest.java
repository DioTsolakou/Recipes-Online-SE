package com.example.recipesonline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserUnitTest {
    User u = new User();
    RegisteredUser ru;
    Admin a = new Admin("adminName", "adminUsername", "adminPswd");
    Recipe recipe;
    static int i = 0;

    @Before
    public void createRecipeTest() {

        u.register("userName", "userUsername", "userPswd", "userPswd");
        ru = (RegisteredUser) u.login("userUsername", "userPswd");
        i++;

        Ingredient ingredient = new Ingredient("ingr1", 100);
        Ingredient ingredient1 = new Ingredient("ingr2", 25);

        MainActivity.Ingredients.add(ingredient);
        MainActivity.Ingredients.add(ingredient1);

        RecipeIngredient recipeIngredient1 = new RecipeIngredient("ingr1", 1, "g");
        RecipeIngredient recipeIngredient2 = new RecipeIngredient("ingr2", 1, "g");

        List<RecipeIngredient> listRI = new ArrayList<>();
        listRI.add(recipeIngredient1);
        listRI.add(recipeIngredient2);

        String type1 = "recipeType1";
        String type2 = "recipeType2";
        List<String> listTypes = new ArrayList<>();
        listTypes.add(type1);
        listTypes.add(type2);

        recipe = new Recipe(ru, "recipeName" + i, listRI, "recipeDesc", listTypes);
        ru.createRecipe("recipeName", listRI, "recipeDesc", listTypes);
        //System.out.println("Recipes created: " + MainActivity.Recipes.size());

    }

    @Test
    public void registerTest() {
        Assert.assertEquals(i, MainActivity.RegisteredUsers.size());
    }

    @Test
    public void loginTest() {
        Assert.assertEquals(i, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void logoutTest() {
        ru.logout("yes");
        Assert.assertEquals(i - 1, MainActivity.LoggedInRegisteredUsers.size());
    }

    @Test
    public void registerAdminTest() {
        MainActivity.Admins.add(a);
        a.register("newAdminName", "newAdminUsername", "newAdminPswd", "newAdminPswd");
        Assert.assertEquals(2, MainActivity.Admins.size());
    }

    @Test
    public void searchTest() {
        Assert.assertEquals(i, ru.search("recipeName").size());
    }

    @Test
    public void searchByTypeTest() {
        Assert.assertEquals(i, ru.searchByType("recipeType1").size());
        Assert.assertEquals(i, ru.searchByType("recipeType2").size());
    }

    @Test
    public void calcRecipeCaloriesTest() {
        Assert.assertEquals(1.25, ru.calcRecipeCalories("recipeName"), 0.0);
    }

    @Test
    public void evaluateTest() {
        ru.evaluate("recipeName", "recipeComments", 5);
        ru.evaluate("recipeName", "recipeComments", 10);
        Assert.assertEquals(2, MainActivity.Recipes.get(0).getEvaluationList().size());
        Assert.assertEquals(7.5, MainActivity.Recipes.get(0).calcEvaluation(), 0.00);
    }
}
