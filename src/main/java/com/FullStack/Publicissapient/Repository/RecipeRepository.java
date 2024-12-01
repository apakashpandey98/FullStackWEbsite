package com.FullStack.Publicissapient.Repository;
//package com.example.recipeapp.repository;

import com.FullStack.Publicissapient.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameContainingAndCuisineContaining(String name, String cuisine);

    List<Recipe> findByNameContaining(String name);

    List<Recipe> findByCuisineContaining(String cuisine);
}
