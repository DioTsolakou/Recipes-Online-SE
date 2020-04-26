package com.example.recipesonline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserUnitTest {

    private User u = new User();
    private RegisteredUser ru;
    private Admin a = new Admin("adminName", "adminUsername", "adminPswd");
    private static int i = 0;
    private Ingredient ingredient1, ingredient2;

    @Before
    public void createRecipeTest() {

        u.register("userName", "userUsername", "userPswd", "userPswd");
        ru = (RegisteredUser) u.login("userUsername", "userPswd");
        i++;

        ingredient1 = new Ingredient("ingr1");
        ingredient2 = new Ingredient("ingr2");

        MainActivity.Ingredients.add(ingredient1);
        MainActivity.Ingredients.add(ingredient2);

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

        ru.createRecipe("recipeName", listRI, "recipeDesc", listTypes);
        
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
    public void updateIngredientTest() {
        a.updateIngredient("ingr1", "salt", 100);
        a.updateIngredient("ingr2", "pepper", 150);
        Assert.assertEquals(2, MainActivity.Ingredients.size());
        Assert.assertEquals("salt", ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getName());
        Assert.assertEquals("pepper", ((Ingredient)(MainActivity.Ingredients.toArray()[1])).getName());
        Assert.assertEquals(100, ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getCalories());
        Assert.assertEquals(150, ((Ingredient)(MainActivity.Ingredients.toArray()[1])).getCalories());
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
        Assert.assertEquals(0, ru.calcRecipeCalories(i), 0.0);
    }

    @Test
    public void evaluateTest() {
        ru.evaluate(i, "recipeComments", 5);
        ru.evaluate(i, "recipeComments", 10);
        Assert.assertEquals(2, MainActivity.Recipes.get(i-1).getEvaluationList().size());
        Assert.assertEquals(7.5, MainActivity.Recipes.get(i-1).calcEvaluation(), 0.00);
    }
}