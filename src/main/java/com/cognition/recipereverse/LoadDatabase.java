package com.cognition.recipereverse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

// @Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(RecipeRepository recipeRepository) {
        return args -> {
            log.info("Preloading " + recipeRepository.save(new Recipe("Mac and Cheese",
                            "https://www.foodnetwork.com/recipes/ina-garten/mac-and-cheese-recipe2-1945401",
                            Arrays.asList("kosher salt",
                                    "salt",
                                    "vegetable oil",
                                    "elbow macaroni",
                                    "cavatappi",
                                    "quart milk",
                                    "unsalted butter",
                                    "butter",
                                    "all purpose flour",
                                    "gruyere",
                                    "cheddar",
                                    "black pepper",
                                    "pepper",
                                    "nutmeg",
                                    "tomato",
                                    "white bread crumbs",
                                    "bread crumbs"
                            )
                    )
                    )
            );
            log.info("Preloading " + recipeRepository.save(new Recipe("Cookies",
                            "https://www.foodnetwork.com/recipes/alton-brown/the-chewy-recipe-1909046",
                            Arrays.asList("kosher salt",
                                    "unsalted butter",
                                    "butter",
                                    "bread flour",
                                    "kosher salt",
                                    "salt",
                                    "baking soda",
                                    "granulated sugar",
                                    "light brown sugar",
                                    "brown sugar",
                                    "sugar",
                                    "egg",
                                    "egg yolk",
                                    "whole milk",
                                    "vanilla extract",
                                    "semisweet chocolate chips"
                            )
                    )
                    )
            );
        };
    }
}
