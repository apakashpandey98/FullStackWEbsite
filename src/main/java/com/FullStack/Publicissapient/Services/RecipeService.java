package com.FullStack.Publicissapient.Services;
import com.FullStack.Publicissapient.Entity.Recipe;
import com.FullStack.Publicissapient.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> searchRecipes(String name, String cuisine) {
        if (name != null && cuisine != null) {
            return recipeRepository.findByNameContainingAndCuisineContaining(name, cuisine);
        } else if (name != null) {
            return recipeRepository.findByNameContaining(name);
        } else if (cuisine != null) {
            return recipeRepository.findByCuisineContaining(cuisine);
        } else {
            return recipeRepository.findAll(); // Return all recipes if no criteria
        }
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
    }
}
