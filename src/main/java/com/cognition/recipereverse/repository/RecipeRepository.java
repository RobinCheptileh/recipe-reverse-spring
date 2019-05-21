package com.cognition.recipereverse.repository;

import com.cognition.recipereverse.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(value = "SELECT DISTINCT i.ingredients FROM recipe_ingredients i WHERE i.ingredients LIKE CONCAT('%',:searchTerm,'%')", nativeQuery = true)
    List<String> searchIngredients(@Param("searchTerm") String searchTerm);
}
