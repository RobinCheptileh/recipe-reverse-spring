package com.cognition.recipereverse;

public class RecipeNotFoundException extends RuntimeException {
    RecipeNotFoundException(Long id) {
        super("Cannot find recipe " + id);
    }
}
