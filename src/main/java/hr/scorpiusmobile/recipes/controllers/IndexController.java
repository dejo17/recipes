package hr.scorpiusmobile.recipes.controllers;

import hr.scorpiusmobile.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String showIndexPage(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        log.debug("Index controller mapped");
        return "index";
    }
}
