package com.cognition.recipereverse.controller;

import com.cognition.recipereverse.model.Recipe;
import com.cognition.recipereverse.service.RecipeService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Recipes Management")
@CrossOrigin(origins = {
        "http://localhost:4200/"
})
@RestController
@RequestMapping("recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ApiOperation(value = "Create a new recipe")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created a new recipe"),
            @ApiResponse(code = 400, message = "Bad request due to missing or invalid parameters"),
            @ApiResponse(code = 500, message = "Error in creating the recipe")
    })
    @PostMapping("")
    ResponseEntity<Recipe> newRecipe(
            @ApiParam(value = "Recipe object to be created") @Valid @RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.newRecipe(recipe), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Create new recipes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created new recipes"),
            @ApiResponse(code = 400, message = "Bad request due to missing or invalid parameters"),
            @ApiResponse(code = 500, message = "Error in creating the recipes")
    })
    @PostMapping("/many")
    ResponseEntity<List<Recipe>> newRecipes(
            @ApiParam(value = "List of recipe objects to be created") @RequestBody List<Recipe> recipes) {
        return new ResponseEntity<>(recipeService.newRecipes(recipes), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a recipe by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved recipe"),
            @ApiResponse(code = 400, message = "Bad request due to missing or invalid parameters"),
            @ApiResponse(code = 404, message = "Recipe not found. Invalid id"),
            @ApiResponse(code = 500, message = "Error in retrieving the recipe")
    })
    @GetMapping("/{id}")
    ResponseEntity<Recipe> getRecipe(
            @ApiParam(value = "id of recipe to find") @PathVariable Long id) {
        return new ResponseEntity<>(recipeService.getRecipe(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get a list of all recipes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved recipes"),
            @ApiResponse(code = 500, message = "Error in retrieving the recipes")
    })
    @GetMapping("")
    ResponseEntity<List<Recipe>> getRecipes() {
        return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update a recipe by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the recipe"),
            @ApiResponse(code = 400, message = "Bad request due to missing or invalid parameters"),
            @ApiResponse(code = 500, message = "Error in updating the recipe")
    })
    @PutMapping("/{id}")
    ResponseEntity<Recipe> replaceRecipe(
            @ApiParam(value = "Recipe object to be used for update") @Valid @RequestBody Recipe newRecipe,
            @ApiParam(value = "id of the recipe to update") @PathVariable Long id) {
        return new ResponseEntity<>(recipeService.replaceRecipe(newRecipe, id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a recipe by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the recipe"),
            @ApiResponse(code = 400, message = "Bad request due to missing or invalid parameters"),
            @ApiResponse(code = 404, message = "Recipe not found. Invalid id"),
            @ApiResponse(code = 500, message = "Error in retrieving the recipes")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRecipe(
            @ApiParam(value = "id of the recipe to be deleted") @PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Get a recommendation of recipes by specifying ingredients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the recommendations"),
            @ApiResponse(code = 400, message = "Bad request due to missing or invalid parameters"),
            @ApiResponse(code = 500, message = "Error in retrieving the recommendations")
    })
    @GetMapping("/recommendations")
    ResponseEntity<List<Recipe>> getRecommendations(
            @ApiParam(value = "List of ingredients") @RequestParam List<String> ingredients) {
        return new ResponseEntity<>(recipeService.getRecommendations(ingredients), HttpStatus.OK);
    }

    @ApiOperation(value = "Search for ingredients")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the search results"),
            @ApiResponse(code = 400, message = "Bad request due to missing or invalid parameters"),
            @ApiResponse(code = 500, message = "Error in retrieving the results")
    })
    @GetMapping("/ingredients")
    ResponseEntity<List<String>> searchIngredients(
            @ApiParam(value = "Term to be used for search") @RequestParam String searchTerm) {
        return new ResponseEntity<>(recipeService.searchIngredients(searchTerm), HttpStatus.OK);
    }
}
