package com.cognition.recipereverse.service.impl;

import com.cognition.recipereverse.exception.RecipeNotFoundException;
import com.cognition.recipereverse.model.Recipe;
import com.cognition.recipereverse.repository.RecipeRepository;
import com.cognition.recipereverse.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe newRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> newRecipes(List<Recipe> recipes) {
        return recipeRepository.saveAll(recipes);
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe replaceRecipe(Recipe newRecipe, Long id) {
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipe.setName(newRecipe.getName());
                    recipe.setUrl(newRecipe.getUrl());
                    recipe.setIngredients(newRecipe.getIngredients());

                    return recipeRepository.save(recipe);
                })
                .orElseGet(() -> {
                    newRecipe.setId(id);
                    return recipeRepository.save(newRecipe);
                });
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public List<Recipe> getRecommendations(List<String> ingredients) {
        List<Recipe> recommendations = new ArrayList<>();

        for (Recipe recipe : recipeRepository.findAll())
            if (recipe.getIngredients().containsAll(ingredients))
                recommendations.add(recipe);

        return recommendations;
    }

    @Override
    public List<String> searchIngredients(String searchTerm) {
        return recipeRepository.searchIngredients(searchTerm);
    }
}
