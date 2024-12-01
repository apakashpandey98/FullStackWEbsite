package com.FullStack.Publicissapient.Services;



import com.FullStack.Publicissapient.Entity.Recipe;
import com.FullStack.Publicissapient.Entity.RecipesResp;
import com.FullStack.Publicissapient.Repository.RecipeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
    public class DataLoaderService {

        @Autowired
        private RecipeRepository recipeRepository;

        private static final String API_URL = "https://dummyjson.com/recipes";

        @PostConstruct
        public RecipesResp loadRecipesData() {
            // Fetch data from external API
            RecipesResp recipe = new RecipesResp();
            try {
                RestTemplate template = new RestTemplate();

                recipe = template.getForObject(API_URL, RecipesResp.class);


                if (recipe != null) {
                   List<Recipe> recipeList=  recipe.getRecipes();

                    saveRecipe(recipeList);  // Save to in-memory H2 database
                }




            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return recipe;
        }
        @Transactional
        public synchronized void saveRecipe(List<Recipe> recipeList){
            for (Recipe recipe : recipeList) {
               // System.out.println(recipe.getIngredients());
                recipeRepository.saveAndFlush(recipe);
            }
    }

    }
