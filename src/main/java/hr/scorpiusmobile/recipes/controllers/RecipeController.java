package hr.scorpiusmobile.recipes.controllers;

import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){

        Recipe recipe =  (Recipe)recipeService.findById(new Long(id));
        model.addAttribute("recipe", recipe);
        model.addAttribute("prepTime", recipe.getPrepTime() );
        model.addAttribute("cookTime", recipe.getCookTime() );
        model.addAttribute("categories", recipe.getCategories());
        model.addAttribute("serving", recipe.getServing());
        model.addAttribute("source", recipe.getSource() );
        model.addAttribute("url", recipe.getUrl() );

        log.debug("Recipe controller mapped");
        return "recipe/show";
    }

}
