package com.example.recipesonline.view.SearchResults;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipesonline.R;
import com.example.recipesonline.domain.Recipe;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> implements View.OnClickListener{

    private Recipe[] recipes;

    // RecyclerView recyclerView;
    public SearchAdapter(Recipe[] listRecipes) {
        this.recipes = listRecipes;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.search_results_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onClick(View view) {}

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Recipe rcp = recipes[position];
        holder.textName.setText(recipes[position].getName());
        holder.textRating.setText(String.valueOf(recipes[position].calcEvaluation()));
        holder.textCreator.setText(recipes[position].getUser().getName());
        holder.constraintLayout.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {
        return recipes.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName;
        public TextView textRating;
        public TextView textCreator;
        public ConstraintLayout constraintLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textName = itemView.findViewById(R.id.textRecipe);
            this.textRating = itemView.findViewById(R.id.textRating);
            this.textCreator = itemView.findViewById(R.id.textCreator);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);
        }
    }


}
