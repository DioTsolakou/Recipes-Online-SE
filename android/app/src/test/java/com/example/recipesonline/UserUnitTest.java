package com.example.recipesonline;

import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.Evaluation;
import com.example.recipesonline.domain.Ingredient;
import com.example.recipesonline.domain.Recipe;
import com.example.recipesonline.domain.RecipeIngredient;
import com.example.recipesonline.domain.RegisteredUser;
import com.example.recipesonline.domain.User;

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
    private Recipe r;
    List<RecipeIngredient> listRI;
    List<String> listRT;

    /* Creates a recipe and the ingredients needed for it. Also creates a registeredUser. This data will be used by all the tests. */
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
        listRI = new ArrayList<>();
        listRI.add(ri1);
        listRI.add(ri2);

        String rt1 = "recipeType1";
        String rt2 = "recipeType2";
        listRT = new ArrayList<>();
        listRT.add(rt1);
        listRT.add(rt2);

        ru.createRecipe("recipeName", listRI, "recipeDesc", listRT);
        r = (Recipe)(MainActivity.Recipes.toArray()[0]);
        Assert.assertEquals(1, MainActivity.Recipes.size());
    }

    /* Tests if a user can be registered successfully as an admin or registered User*/
    @Test
    public void registerTest() {
        u.register("userName", "userUsername", "userPswd", "userPswd");
        Assert.assertEquals(1, MainActivity.RegisteredUsers.size());
        a.register("newAdminName", "newAdminUsername", "newAdminPswd", "newAdminPswd");
        Assert.assertEquals(2, MainActivity.Admins.size());
    }

    /* Tests if an admin or a registered user can login and if not registered users aren't accepted*/
    @Test
    public void loginTest() {
        RegisteredUser tempRU = (RegisteredUser) u.login("fakeUsername", "fakePswd");
        Assert.assertNull(tempRU);
        Assert.assertEquals(1, MainActivity.LoggedInRegisteredUsers.size());
        Assert.assertEquals(1, MainActivity.LoggedInAdmins.size());
    }

    /* Tests if an admin or a registered User can logout successfully */
    @Test
    public void logoutTest() {
        ru.logout();
        a.logout();
        Assert.assertEquals(0, MainActivity.LoggedInRegisteredUsers.size());
        Assert.assertEquals(0, MainActivity.LoggedInAdmins.size());
    }

    /* Tests if an admin can update the ingredients and if the program detects the non-existing ingredient */
    @Test
    public void updateIngredientTest() {
        a.updateIngredient("ingr1", "salt", 100);
        a.updateIngredient("ingr2", "pepper", 150);
        a.updateIngredient("fakeIngr", "fake", 0);
        Assert.assertEquals(2, MainActivity.Ingredients.size());
        Assert.assertEquals("pepper", ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getName());
        Assert.assertEquals(150, ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getCalories());
        Assert.assertEquals("salt", ((Ingredient)(MainActivity.Ingredients.toArray()[1])).getName());
        Assert.assertEquals(100, ((Ingredient)(MainActivity.Ingredients.toArray()[1])).getCalories());
        Assert.assertNotEquals(0, ru.calcRecipeCalories(1), 0.0);
    }

    /* Tests if the search detects the actual number of recipes wanted */
    @Test
    public void searchTest() {
        Assert.assertEquals(0, u.search("fakeRecipe", listRT, listRI).size());
        Assert.assertEquals(0, ru.search("fakeRecipe", listRT, listRI, 4 ).size());
        Assert.assertEquals(1, u.search(null, new ArrayList<String>(), listRI).size());
        Assert.assertEquals(1, u.search("recipeName", listRT, listRI).size());
        Assert.assertEquals(1, ru.search("recipeName", listRT, listRI, 0 ).size());
        Assert.assertEquals(1, u.search(null, listRT, listRI).size());
        Assert.assertEquals(1, u.search("recipeName", new ArrayList<String>(), listRI).size());
        Assert.assertEquals(1, u.search("recipeName", listRT, new ArrayList<RecipeIngredient>()).size());
        Assert.assertEquals(0, u.search("fakeRecipe", new ArrayList<String>(), new ArrayList<RecipeIngredient>()).size());
        Assert.assertEquals(1, u.search(null, new ArrayList<String>(), new ArrayList<RecipeIngredient>()).size());
    }

    /* Checks if the calories of a recipe are the expected */
    @Test
    public void calcRecipeCaloriesTest(){
        Assert.assertEquals(0, ru.calcRecipeCalories(1), 0.0);
        Assert.assertEquals(-1, ru.calcRecipeCalories(2), 0.0);
    }

    /* Checks if the evaluation of a recipe is the expected and if the re-evaluations are declined */
    @Test
    public void evaluateTest() {
        ru.evaluate(1, "recipeComments1", 5);
        ru.evaluate(1, "recipeComments2", 10);
        ru.evaluate(2, "fakeComments", 0);
        Assert.assertEquals(1, r.getEvaluationList().size());
        Assert.assertEquals(5, r.calcEvaluation(), 0.00);
    }

    /* Checks if the registered user can add an ingredient in his recipe successfully */
    @Test
    public void addIngredientTest() {
        Assert.assertEquals(2, MainActivity.Ingredients.size());
        int sizeBefore = r.getIngredients().size();
        r.addIngredient(new RecipeIngredient("ingr3", 200, "ml"));
        int sizeAfter = r.getIngredients().size();
        r.addIngredient(new RecipeIngredient("ingr1", 200, "ml"));
        Assert.assertEquals(sizeAfter, sizeBefore + 1);
        Assert.assertEquals(3, MainActivity.Ingredients.size());

        a.updateIngredient("ingr3", "water", 1);
        Assert.assertEquals("water", ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getName());
        Assert.assertEquals(1, ((Ingredient)(MainActivity.Ingredients.toArray()[0])).getCalories());
    }


    /* Deletes all the data contained in lists and IDs of recipes and ingredients when a test is completed */
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