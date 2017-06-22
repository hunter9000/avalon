package avalon.controller;

import avalon.model.character.Character;
import avalon.model.items.equipment.Equipment;
import avalon.model.items.equipment.ItemEffect;
import avalon.model.items.material.Material;
import avalon.model.items.recipe.Recipe;
import avalon.model.items.recipe.RecipeRequirement;
import avalon.repository.CharRepository;
import avalon.repository.RecipeRepository;
import avalon.request.RecipeCraftRequest;
import avalon.response.SuccessResponse;
import avalon.security.JwtSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class RecipeController {

    @Autowired
    private CharRepository charRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private HttpServletRequest request;

/*    @RequestMapping(value="/api/char/{charId}/recipes/", method=RequestMethod.GET)
    public List<Recipe> getRecipes(@PathVariable long charId) {
        // return all recipes this user has unlocked
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
//        long charId = token.getCharId();
        // todo validate that charId belongs to user

        Character charModel = charRepository.findById(charId);

        List<Recipe> recipes = charModel.getRecipes();

        return recipes;
    }*/

    @RequestMapping(value="/api/char/{charId}/recipes", method=RequestMethod.POST)
    public SuccessResponse craftRecipe(@PathVariable long charId, @RequestBody RecipeCraftRequest recipeRequest) {
        System.out.println(recipeRequest);
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
//        long charId = token.getCharId();
        Character character = charRepository.findById(charId);

        // verify that the char has the recipe unlocked
        Recipe selectedRecipe = null;
        for (Recipe recipe : character.getRecipes()) {
            if (recipe.getId() == recipeRequest.getId()) {
                selectedRecipe = recipe;
                break;
            }
        }
        if (selectedRecipe == null) {
            return new SuccessResponse(false, "given recipe is not accessible to character");
        }

        // verify that the char has all the req and extra mats in inv
        List<Material> requiredMaterials = new ArrayList<>();

        Set<RecipeRequirement> requirements = selectedRecipe.getRecipeReqs();
        for (RecipeRequirement req : requirements) {
            requiredMaterials.add(req.getMaterial());
        }

        // check the capacity of the recipe


        // remove mats from inv, add crafted item w/ attached effects to inv
        Equipment equipment = new Equipment();
        equipment.setItem(selectedRecipe.getItem());
        equipment.setCharacter(character);
        equipment.setItemEffects(new ArrayList<ItemEffect>());
        character.getInventoryEquipment().add(equipment);

        charRepository.save(character);

        return new SuccessResponse(true, "");
    }
}
