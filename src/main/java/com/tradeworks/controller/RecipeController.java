/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tradeworks.controller;

import com.tradeworks.model.Recipe;
import com.tradeworks.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Recipe read(@RequestParam(value = "id") long id) {
        return recipeRepository.findOne(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Recipe recipe) {
        recipeRepository.delete(recipe);
    }

}
