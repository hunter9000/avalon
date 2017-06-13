package avalon.controller;

import avalon.model.CharModel;
import avalon.model.items.*;
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

@RestController
public class RecipeController {

    @Autowired
    private CharRepository charRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/api/char/{charId}/recipes/", method=RequestMethod.GET)
    public List<RecipeModel> getRecipes(@PathVariable long charId) {
        // return all recipes this user has unlocked
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
//        long charId = token.getCharId();
        // todo validate that charId belongs to user

        CharModel charModel = charRepository.findById(charId);

        List<RecipeModel> recipes = charModel.getRecipes();

        return recipes;
    }

    @RequestMapping(value="/api/char/{charId}/recipes", method=RequestMethod.POST)
    public SuccessResponse craftRecipe(@PathVariable long charId, @RequestBody RecipeCraftRequest recipeRequest) {
        System.out.println(recipeRequest);
        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
//        long charId = token.getCharId();
        CharModel charModel = charRepository.findById(charId);

        // verify that the char has the recipe unlocked
        RecipeModel selectedRecipe = null;
        for (RecipeModel recipe : charModel.getRecipes()) {
            if (recipe.getId() == recipeRequest.getId()) {
                selectedRecipe = recipe;
                break;
            }
        }
        if (selectedRecipe == null) {
            return new SuccessResponse(false, "given recipe is not accessible to character");
        }

        // verify that the char has all the req and extra mats in inv
        List<MaterialModel> requiredMaterials = new ArrayList<>();

        List<RecipeRequirementModel> requirements = selectedRecipe.getRecipeReqs();
        for (RecipeRequirementModel req : requirements) {
            requiredMaterials.add(req.getMaterialModel());
        }

        // check the capacity of the recipe


        // remove mats from inv, add crafted item w/ attached effects to inv
        EquipmentModel equipmentModel = new EquipmentModel();
        equipmentModel.setItemModel(selectedRecipe.getItem());
        equipmentModel.setCharModel(charModel);
        equipmentModel.setItemEffects(new ArrayList<ItemEffectModel>());
        charModel.getInventoryEquipment().add(equipmentModel);

        charRepository.save(charModel);

        return new SuccessResponse(true, "");
    }
}
