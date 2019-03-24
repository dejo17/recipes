package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.converters.IngredientCommandToIngredient;
import hr.scorpiusmobile.recipes.converters.IngredientToIngredientCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

    RecipeRepository recipeRepository;
    IngredientToIngredientCommand ingredientToIngredientCommand;
    IngredientCommandToIngredient ingredientCommandToIngredient;

    public IngredientServiceImpl(RecipeRepository recipeRepository,
                                 IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
    }

    @Override
    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId ) {
         Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

         if (!recipeOptional.isPresent()){
             throw new RuntimeException("Recipe not found when searching for ingredients");
         }
        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
        if (!ingredientCommandOptional.isPresent()){
            throw new RuntimeException("Ingredient not found when searching for ingredients via Recipe ID");
        }else{
            log.debug("Ingredient found by recipe and ingredient id");
        }
         return ingredientCommandOptional.get();
    }
}
