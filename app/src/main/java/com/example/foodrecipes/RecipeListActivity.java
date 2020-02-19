package com.example.foodrecipes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodrecipes.models.Recipe;

import com.example.foodrecipes.util.Testing;
import com.example.foodrecipes.viewmodels.RecipeListViewModel;


import java.util.List;



public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        mRecipeListViewModel = new ViewModelProvider(this).get(RecipeListViewModel.class);

        subscribeObservers();
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });
    }

    private void subscribeObservers(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                if (recipes != null) {
                    Testing.printRecipes(recipes, "recipes test");
                }
            }
        });
    }

    private void searchRecipesApi(String query, int pageNumber){
        mRecipeListViewModel.searchRecipesApi(query, pageNumber);
    }

    private void testRetrofitRequest(){
        searchRecipesApi("chicken", 1);
    }
}
