package com.cognition.recipereverse.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(Long id) {
        super("Cannot find recipe " + id);
    }
}
