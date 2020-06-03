package com.example.recipesonline.view.SearchResults;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.recipesonline.R;
import com.example.recipesonline.domain.Recipe;
import java.util.HashSet;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultsView{

    private RecyclerView recyclerView;
    private SearchResultsPresenter searchResultsPresenter;
    private HashSet<Recipe> searchResults;
    private Recipe[] searchResultsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        searchResultsPresenter = new SearchResultsPresenter(this);

        recyclerView = findViewById(R.id.resultsRecycler);

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
    protected void onPause()
    {
        super.onPause();
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
