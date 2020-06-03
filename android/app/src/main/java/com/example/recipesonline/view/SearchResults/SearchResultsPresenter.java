package com.example.recipesonline.view.SearchResults;

import com.example.recipesonline.domain.Recipe;
import com.example.recipesonline.domain.Utilities;

public class SearchResultsPresenter {

    private SearchResultsView view;

    public SearchResultsPresenter(SearchResultsView view) {
        this.view = view;
    }

    public void onLogout()
    {
        Utilities.getUser().logout();
    }
}
