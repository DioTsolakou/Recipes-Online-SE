package com.example.recipesonline.view.Recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.R;
import com.example.recipesonline.domain.Evaluation;
import com.example.recipesonline.domain.Recipe;
import com.example.recipesonline.domain.RecipeIngredient;
import com.example.recipesonline.domain.RegisteredUser;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.Home.HomeActivity;
import com.example.recipesonline.view.Login.LoginActivity;

import org.w3c.dom.Text;

public class RecipeActivity extends AppCompatActivity implements RecipeView, View.OnClickListener{

    private RecipePresenter recipePresenter;
    private TextView logo;
    private Recipe recipe;
    private TextView creator;
    private TextView totalRating;
    private TableLayout tblIngredients;
    private TableLayout tblTypes;
    private TextView description;
    private EditText etComment;
    private EditText etRating;
    private TextView txtCalories;
    private Button btnSaveComment;
    private TableLayout tblComments;
    private String recipeToBeShown;
    private Button loginBtn;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipePresenter = new RecipePresenter(this);

        Intent intent = getIntent();

        recipe = (Recipe) intent.getSerializableExtra("Recipe");

        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(this);

        logoutBtn = findViewById(R.id.logoutButton);
        logoutBtn.setOnClickListener(this);

        if(recipe.getName() != null)
            logo.setText(recipe.getName());

        creator = findViewById(R.id.txtCreator);
        creator.setText(recipe.getUser().getUsername());
        totalRating = findViewById(R.id.txtRating);
        totalRating.setText(String.valueOf(recipe.calcEvaluation()));

        tblIngredients = findViewById(R.id.tblIngredients);
        for (RecipeIngredient ri: recipe.getIngredients()) {
            TextView tv = new TextView(this);
            tv.setText(ri.getIngredient().toString());
            TableRow row = new TableRow(this);
            row.addView(tv);
            tblIngredients.addView(row);
        }

        tblTypes = findViewById(R.id.tblTypes);
        for (String type: recipe.getTypes()) {
            TextView tv = new TextView(this);
            tv.setText(type);
            TableRow row = new TableRow(this);
            row.addView(tv);
            tblTypes.addView(row);
        }

        description = findViewById(R.id.rcpDescription);
        description.setText(recipe.getDescription());


        for (Evaluation e: recipe.getEvaluationList()) {
            TextView tv = new TextView(this);

            recipeToBeShown = e.getUser() + " (" + e.getRating()+ ")\n" + e.getComments();

            tv.setText(recipeToBeShown);
            TableRow row = new TableRow(this);
            row.addView(tv);
            tblComments.addView(row);
        }

        etComment = findViewById(R.id.editTxtComment);
        etRating = findViewById(R.id.editTxtRating);
        txtCalories = findViewById(R.id.txtCalories);
        txtCalories.setText(String.valueOf(((RegisteredUser)Utilities.getUser()).calcRecipeCalories(recipe.getId())));
        btnSaveComment = findViewById(R.id.btnSaveComment);
        btnSaveComment.setOnClickListener(this);
        tblComments = findViewById(R.id.tblComments);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if ((Utilities.getLoggedInUsers().contains(Utilities.getUser())) || Utilities.getLoggedInAdmins().contains(Utilities.getUser())){
            loginBtn.setVisibility(View.INVISIBLE);
            logoutBtn.setVisibility(View.VISIBLE);
        }
        else {
            loginBtn.setVisibility(View.VISIBLE);
            logoutBtn.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnSaveComment) {
            recipePresenter.onSaveComment();
        }
        if (v == loginBtn) {
            Intent intent = new Intent(RecipeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (v == logoutBtn) {
            recipePresenter.onLogout();
            finish();
            startActivity(getIntent());
        }
    }

    public String getCreator() {return creator.getText().toString();}
    public void setCreator(String value) {creator.setText(value);}

    public String getTotalRating() {return totalRating.getText().toString();}
    public void setTotalRating(double value) {totalRating.setText(String.valueOf(value));}

    public TableLayout getIngredients() {
        return tblIngredients;
    }
    public void setIngredients(TableLayout tableLayout) {
        tblIngredients = tableLayout;
    }

    public TableLayout getTypes() {
        return tblTypes;
    }
    public void setTypes(TableLayout tableLayout) {
        tblTypes = tableLayout;
    }

    public String getDescription() {return description.getText().toString();}
    public void setDescription(String value) {description.setText(value);}

    public TableLayout getComments() {
        return tblComments;
    }
    public void setComments(TableLayout tableLayout) {
        tblComments = tableLayout;
    }

    public String getComment() {return etComment.getText().toString().trim();}
    public void setComment(String value) {etComment.setText(value);}

    public int getRating() {return Integer.parseInt(etRating.getText().toString().trim());}
    public void setRating(int value) {etRating.setText(value);}

}