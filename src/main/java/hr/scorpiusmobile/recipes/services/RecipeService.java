package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.RecipeCommand;

import java.util.Set;

public interface RecipeService<Recipe, Object extends Long> {

    Set<Recipe> getRecipes();

    Recipe findById(Object id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

}
