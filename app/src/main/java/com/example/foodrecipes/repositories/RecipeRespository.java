package com.example.foodrecipes.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.requests.RecipeApiClient;

import java.util.List;

public class RecipeRespository {

    private static RecipeRespository instance;
    private RecipeApiClient mRecipeApiClient;

    public static RecipeRespository getInstance(){
        if (instance == null){
            instance = new RecipeRespository();
        }
        return instance;
    }

    private RecipeRespository(){
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeApiClient.getRecipes();
    }
}
