/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tradeworks.controller;

import com.tradeworks.model.Ingredient;
import com.tradeworks.model.Recipe;
import com.tradeworks.model.Step;
import com.tradeworks.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YNZ
 */
@RestController
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        for(Ingredient ingredient :  recipe.getIngredients()){
            ingredient.setRecipe(recipe);
        }
        
        for(Step step: recipe.getInstructions()){
            step.setRecipe(recipe);
        }
        
        Recipe savedRecipe = recipeRepository.save(recipe);
        return new ResponseEntity<>(savedRecipe,HttpStatus.CREATED); 
        
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Recipe read(@RequestParam(value = "id") long id) {
        return recipeRepository.findOne(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Recipe recipe) {
        recipeRepository.delete(recipe);
    }
    
    @RequestMapping(value="/greeting")
    public String greeting(){
        return "hi!";
    }
    
    
    
}
