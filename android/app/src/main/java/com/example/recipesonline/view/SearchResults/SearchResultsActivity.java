package com.example.recipesonline.view.SearchResults;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.recipesonline.R;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultsView{

    private RecyclerView recyclerView;
    private SearchResultsPresenter searchResultsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        searchResultsPresenter = new SearchResultsPresenter(this);

        recyclerView = findViewById(R.id.resultsRecycler);

        SearchAdapter adapter = new SearchAdapter(myListData);
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
