package hr.scorpiusmobile.recipes.controllers;

import hr.scorpiusmobile.recipes.services.IngredientService;
import hr.scorpiusmobile.recipes.services.RecipeService;
import hr.scorpiusmobile.recipes.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IngredientController {

    RecipeService recipeService;
    IngredientService ingredientService;
    UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService,
                                IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/ingredients")
    public String listIngredients(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/ingredients/list";
    }
    @GetMapping
    @RequestMapping("/recipe/{id}/ingredients/{id2}/show")
    public String showIngredient(@PathVariable String id, @PathVariable String id2, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(id),Long.valueOf(id2)));
        return "recipe/ingredients/show";
    }
}
