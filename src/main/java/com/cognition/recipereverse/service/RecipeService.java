package com.cognition.recipereverse.service;

import com.cognition.recipereverse.model.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe newRecipe(Recipe recipe);

    List<Recipe> newRecipes(List<Recipe> recipes);

    Recipe getRecipe(Long id);

    List<Recipe> getRecipes();

    Recipe replaceRecipe(Recipe newRecipe, Long id);

    void deleteRecipe(Long id);

    List<Recipe> getRecommendations(List<String> ingredients);

    List<String> searchIngredients(String ingredient);
}
