package com.example.foodrecipes.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.repositories.RecipeRespository;

public class RecipeViewModel extends ViewModel {

    private RecipeRespository mRecipeRepository;
    private String mRecipeId;
    private boolean mDidRetrieveRecipe;

    public RecipeViewModel(){
        mRecipeRepository = RecipeRespository.getInstance();
        mDidRetrieveRecipe = false;
    }

    public LiveData<Recipe> getRecipe(){
        return mRecipeRepository.getRecipe();
    }

    public LiveData<Boolean> isRecipeRequestTimedOut(){
        return mRecipeRepository.isRecipeRequestTimedOut();
    }

    public void searchRecipeById(String recipeId){
        mRecipeId = recipeId;
        mRecipeRepository.searchRecipeById(recipeId);
    }

    public String getmRecipeId() {
        return mRecipeId;
    }

    public boolean DidRetrieveRecipe() {
        return mDidRetrieveRecipe;
    }

    public void setRetrievedRecipe(boolean retrievedRecipe) {
        mDidRetrieveRecipe = retrievedRecipe;
    }
}
