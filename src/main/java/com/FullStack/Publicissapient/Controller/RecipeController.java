package com.FullStack.Publicissapient.Controller;

import com.FullStack.Publicissapient.Entity.Recipe;
import com.FullStack.Publicissapient.Entity.RecipesResp;
import com.FullStack.Publicissapient.Services.DataLoaderService;
import com.FullStack.Publicissapient.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private DataLoaderService dataLoaderService;

    @GetMapping("/search")
    public List<Recipe> searchRecipes(@RequestParam(required = false) String name, @RequestParam(required = false) String cuisine) {
        return recipeService.searchRecipes(name, cuisine);
    }
    @GetMapping("/load")
    public RecipesResp loadRecipes() {
        return dataLoaderService.loadRecipesData();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable("id") Long id) {
        return recipeService.getRecipeById(id);
    }
}
