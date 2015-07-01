package com.test.controller;

public class RecipeController {

    @RestController(name="/api/recipes", GET)
    public List<Recipe> getRecipes() {
        // return all recipes this user has unlocked
    }
    @RestController(name="/api/recipes", POST)
    public void craftRecipe() {
        // takes the posted recipe, the extra mats
        // check if the char has all the req and extra mats in inv
        // remove mats from inv, add crafted item w/ attached effects to inv
    }
}
