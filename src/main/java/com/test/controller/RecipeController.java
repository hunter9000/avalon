package com.test.controller;

import com.test.model.CharModel;
import com.test.model.RecipeModel;
import com.test.model.User;
import com.test.repository.CharRepository;
import com.test.repository.RecipeRepository;
import com.test.repository.UserRepository;
import com.test.security.JwtSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private CharRepository charRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/recipes/", method=RequestMethod.GET)
    public List<RecipeModel> getRecipes() {
        // return all recipes this user has unlocked
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
        long charId = token.getCharId();
        // todo validate that charId belongs to user

        CharModel charModel = charRepository.findById(charId);

        List<RecipeModel> recipes = charModel.getRecipes();

        return recipes;
    }

    @RequestMapping(value="/api/recipes", method=RequestMethod.POST)
    public void craftRecipe() {
        // takes the posted recipe, the extra mats
        // check if the char has all the req and extra mats in inv
        // remove mats from inv, add crafted item w/ attached effects to inv
    }
}
