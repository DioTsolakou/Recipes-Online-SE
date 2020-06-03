package com.example.recipesonline.view.SearchResults;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recipesonline.R;
import com.example.recipesonline.domain.Admin;
import com.example.recipesonline.domain.Recipe;
import com.example.recipesonline.domain.RegisteredUser;
import com.example.recipesonline.domain.Utilities;
import com.example.recipesonline.view.CreateRecipe.CreateRecipeActivity;
import com.example.recipesonline.view.Home.HomeActivity;
import com.example.recipesonline.view.Login.LoginActivity;
import com.example.recipesonline.view.UpdateIngredient.UpdateIngredientActivity;

import java.util.HashSet;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultsView, View.OnClickListener{

    private RecyclerView recyclerView;
    private SearchResultsPresenter searchResultsPresenter;
    private HashSet<Recipe> searchResults;
    private Recipe[] searchResultsArray;
    private Button loginBtn;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        searchResultsPresenter = new SearchResultsPresenter(this);

        recyclerView = findViewById(R.id.resultsRecycler);

        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(this);

        logoutBtn = findViewById(R.id.logoutButton);
        logoutBtn.setOnClickListener(this);

        Intent intent = getIntent();
        searchResults = (HashSet<Recipe>) intent.getSerializableExtra("Search_Results");

        searchResultsArray = new Recipe[searchResults.size()];
        searchResults.toArray(searchResultsArray);

        SearchAdapter adapter = new SearchAdapter(searchResultsArray);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v == loginBtn) {
            Intent intent = new Intent(SearchResultsActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (v == logoutBtn) {
            searchResultsPresenter.onLogout();
            finish();
            startActivity(getIntent());
        }
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
        if (Utilities.getUser() != null) {
            if ((Utilities.getLoggedInUsers().contains(Utilities.getUser()) || Utilities.getLoggedInAdmins().contains(Utilities.getUser())))
            {
                loginBtn.setVisibility(View.INVISIBLE);
                logoutBtn.setVisibility(View.VISIBLE);
            }
            else {
                loginBtn.setVisibility(View.VISIBLE);
                logoutBtn.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public RecyclerView getRecycler() {
        return recyclerView;
    }

    @Override
    public void setRecycler(RecyclerView recycler) {
        recyclerView = recycler;
    }
}
