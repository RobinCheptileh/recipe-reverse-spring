package com.cognition.recipereverse.controller;

import com.cognition.recipereverse.model.Recipe;
import com.cognition.recipereverse.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("")
    ResponseEntity<Recipe> newRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.newRecipe(recipe), HttpStatus.CREATED);
    }

    @PostMapping("/many")
    ResponseEntity<List<Recipe>> newRecipes(@RequestBody List<Recipe> recipes) {
        return new ResponseEntity<>(recipeService.newRecipes(recipes), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        return new ResponseEntity<>(recipeService.getRecipe(id), HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<Recipe>> getRecipes() {
        return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Recipe> replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
        return new ResponseEntity<>(recipeService.replaceRecipe(newRecipe, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/recommendations")
    ResponseEntity<List<Recipe>> getRecommendations(@RequestParam List<String> ingredients) {
        return new ResponseEntity<>(recipeService.getRecommendations(ingredients), HttpStatus.OK);
    }

    @GetMapping("/ingredients")
    ResponseEntity<List<String>> searchIngredients(@RequestParam String searchTerm) {
        return new ResponseEntity<>(recipeService.searchIngredients(searchTerm), HttpStatus.OK);
    }
}
