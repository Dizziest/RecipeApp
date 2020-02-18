package com.example.foodrecipes.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.repositories.RecipeRespository;

import java.util.List;

public class RecipeListViewModel extends ViewModel {

    private RecipeRespository mRecipeRepository;

    public RecipeListViewModel() {
        mRecipeRepository = RecipeRespository.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeRepository.getRecipes();
    }
}
