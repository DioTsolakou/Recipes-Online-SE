package com.example.recipesonline;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserUnitTest {

    private User u;
    private RegisteredUser ru;
    private Admin a;
    //private static int i = 0;
    private Recipe r;

    @Before
    public void createRecipeTest() {

        u = new User();
        u.register("userName", "userUsername", "userPswd", "userPswd");
        ru = (RegisteredUser) u.login("userUsername", "userPswd");
        MainActivity.Admins.add(new Admin("adminName", "adminUsername", "adminPswd"));
        a = (Admin) u.login("adminUsername", "adminPswd");

        Ingredient i1 = new Ingredient("ingr1");
        Ingredient i2 = new Ingredient("ingr2");
        MainActivity.Ingredients.add(i1);
        MainActivity.Ingredients.add(i2);

        RecipeIngredient ri1 = new RecipeIngredient("ingr1", 1, "g");
        RecipeIngredient ri2 = new RecipeIngredient("ingr2", 1, "g");
        List<RecipeIngredient> listRI = new ArrayList<>();
        listRI.add(ri1);
        listRI.add(ri2);

        String rt1 = "recipeType1";
        String rt2 = "recipeType2";
        List<String> listRT = new ArrayList<>();
        listRT.add(rt1);
        listRT.add(rt2);

        ru.createRecipe("recipeName", listRI, "recipeDesc", listRT);
        r = MainActivity.Recipes.get(0);
        Assert.assertEquals(1, MainActivity.Recipes.size());

    }

    @Test
    public void registerTest() {
        Assert.assertEquals(1, MainActivity.RegisteredUsers.size());
        a.register("newAdminName", "newAdminUsername", "newAdminPswd", "newAdminPswd");
        Assert.assertEquals(2, MainActivity.Admins.size());
    }

    @Test
    public void loginTest() {
        RegisteredUser tempRU = (RegisteredUser) u.login("fakeUsername", "fakePswd");
        Assert.assertNull(tempRU);
        Assert.assertEquals(1, MainActivity.LoggedInRegisteredUsers.size());
        Assert.assertEquals(1, MainActivity.LoggedInAdmins.size());
    }

    @Test
    public void logoutTest() {
        ru.logout("yes");
        a.logout("yes");
        Assert.assertEquals(0, MainActivity.LoggedInRegisteredUsers.size());
        Assert.assertEquals(0, MainActivity.LoggedInAdmins.size());
    }

    @Test
    public void updateIngredientTest() {
        a.updateIngredient("ingr1", "salt", 100);
        a.updateIngredient("ingr2", "pepper", 150);
        a.updateIngredient("fakeIngr", "fake", 0);
        Assert.assertEquals(2, MainActivity.Ingredients.size());
        Assert.assertEquals("salt", ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getName());
        Assert.assertEquals(100, ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getCalories());
        Assert.assertEquals("pepper", ((Ingredient)(MainActivity.Ingredients.toArray()[1])).getName());
        Assert.assertEquals(150, ((Ingredient)(MainActivity.Ingredients.toArray()[1])).getCalories());
        Assert.assertNotEquals(0, ru.calcRecipeCalories(1), 0.0);
    }

    @Test
    public void searchTest() {
        Assert.assertEquals(1, ru.search("recipeName").size());
        Assert.assertEquals(0, ru.search("fakeName").size());
    }

    @Test
    public void searchByTypeTest() {
        Assert.assertEquals(1, ru.searchByType("recipeType1").size());
        Assert.assertEquals(1, ru.searchByType("recipeType2").size());
        Assert.assertEquals(0, ru.searchByType("fakeType").size());
    }

    @Test
    public void calcRecipeCaloriesTest() {
        Assert.assertEquals(0, ru.calcRecipeCalories(1), 0.0);
        Assert.assertEquals(-1, ru.calcRecipeCalories(2), 0.0);
    }

    @Test
    public void evaluateTest() {
        ru.evaluate(1, "recipeComments1", 5);
        ru.evaluate(1, "recipeComments2", 10);
        ru.evaluate(2, "fakeComments", 0);
        Assert.assertEquals(2, r.getEvaluationList().size());
        Assert.assertEquals(7.5, r.calcEvaluation(), 0.00);
    }

    @Test
    public void addIngredientTest() {
        Assert.assertEquals(2, MainActivity.Ingredients.size());
        int sizeBefore = r.getIngredients().size();
        r.addIngredient(new RecipeIngredient("ingr3", 200, "ml"));
        int sizeAfter = r.getIngredients().size();
        Assert.assertEquals(sizeAfter, sizeBefore + 1);
        Assert.assertEquals(3, MainActivity.Ingredients.size());

        a.updateIngredient("ingr3", "water", 1);
        Assert.assertEquals("water", ((Ingredient)(MainActivity.Ingredients.toArray()[2])).getName());
        Assert.assertEquals(1, ((Ingredient)(MainActivity.Ingredients.toArray()[2])).getCalories());
    }

    @After
    public void clearAll() {
        MainActivity.Recipes.clear();
        MainActivity.Ingredients.clear();
        MainActivity.RegisteredUsers.clear();
        MainActivity.LoggedInRegisteredUsers.clear();
        MainActivity.Admins.clear();
        MainActivity.LoggedInAdmins.clear();
        Recipe.clearCount();
        Evaluation.clearCount();
    }

}