package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;

import java.util.Optional;

public interface IngredientService  {
    IngredientCommand findByRecipeIdAndId (Long recipeId, Long ingredientId);
}
