package com.example.foodrecipes.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foodrecipes.models.Recipe;

import java.util.List;

public class RecipeRespository {

    private static RecipeRespository instance;
    private MutableLiveData<List<Recipe>> mRecipes;

    public static RecipeRespository getInstance(){
        if (instance == null){
            instance = new RecipeRespository();
        }
        return instance;
    }

    private RecipeRespository(){
        mRecipes = new MutableLiveData<>();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipes;
    }
}
