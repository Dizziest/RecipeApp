package com.example.foodrecipes.util;

import android.util.Log;

import com.example.foodrecipes.models.Recipe;

import java.util.List;

public class Testing {

    private static final String TAG = "Testing";

    public static void printRecipes(List<Recipe> list, String tag){
        for (Recipe recipe: list){
            Log.d(TAG, "printRecipes: " + recipe.getTitle());
        }
    }
}
