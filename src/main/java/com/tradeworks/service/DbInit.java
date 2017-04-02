/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tradeworks.service;

import com.tradeworks.model.Ingredient;
import com.tradeworks.model.Recipe;
import com.tradeworks.model.Step;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.tradeworks.repository.RecipeRepository;

/**
 *
 * @author YNZ
 */
@Component
public class DbInit implements CommandLineRunner{
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(String... strings) throws Exception {
        
        
        Recipe recipe = new Recipe();
        recipe.setTitle("bread");
        recipe.setPhoto("a phone".getBytes());
        
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setAmount("10g");
        ingredient1.setDescription("powder");
        ingredient1.setRecipe(recipe);
        ingredients.add(ingredient1);
        
        
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setAmount("20g");
        ingredient2.setDescription("butter");
        ingredient2.setRecipe(recipe);
        ingredients.add(ingredient2);
        
        List<Step> instructions =  new ArrayList<>();
        Step instruction1 = new Step();
        instruction1.setNumber("1");
        instruction1.setDescription("adding water");
        instruction1.setRecipe(recipe);
        instructions.add(instruction1);
        
        Step instruction2 = new Step();
        instruction2.setNumber("2");
        instruction2.setDescription("mix powder with water");
        instruction2.setRecipe(recipe);
        instructions.add(instruction2); 
        
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
                
        recipeRepository.save(recipe );
        
    }
    
}
