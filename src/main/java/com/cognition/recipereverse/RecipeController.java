package com.cognition.recipereverse;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    List<Recipe> all() {
        return recipeRepository.findAll();
    }

    @PostMapping("/")
    Recipe newRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @GetMapping("/{id}")
    Recipe oneRecipe(@PathVariable Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @PutMapping("/{id}")
    Recipe replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
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

    @DeleteMapping("/{id}")
    void deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
    }
}
