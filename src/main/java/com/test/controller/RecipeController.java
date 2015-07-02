package com.test.controller;

import com.test.model.RecipeModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class RecipeController {

    @RequestMapping(value="/api/recipes", method=RequestMethod.GET)
    public List<RecipeModel> getRecipes() {
        // return all recipes this user has unlocked
        return null;
    }

    @RequestMapping(value="/api/recipes", method=RequestMethod.POST)
    public void craftRecipe() {
        // takes the posted recipe, the extra mats
        // check if the char has all the req and extra mats in inv
        // remove mats from inv, add crafted item w/ attached effects to inv
    }
}
