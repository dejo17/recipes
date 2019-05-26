package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.converters.IngredientCommandToIngredient;
import hr.scorpiusmobile.recipes.converters.IngredientToIngredientCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import hr.scorpiusmobile.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    RecipeRepository recipeRepository;
    IngredientToIngredientCommand ingredientToIngredientCommand;
    IngredientCommandToIngredient ingredientCommandToIngredient;
    UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(RecipeRepository recipeRepository,
                                 IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient,
                                 UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe not found when searching for ingredients");
        }
        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
        if (!ingredientCommandOptional.isPresent()) {
            throw new RuntimeException("Ingredient not found when searching for ingredients via Recipe ID");
        } else {
            log.debug("Ingredient found by recipe and ingredient id");
        }
        return ingredientCommandOptional.get();
    }

    @Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());
        if (!recipeOptional.isPresent()) {
            log.error("Recipe not found for id: " + command.getRecipeId());
            return new IngredientCommand(); //TODO throw exception if not found
        } else {
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if (ingredientOptional.isPresent()) {
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                /*debug:
                if (command.getUomCommand() == null) {
                    log.debug("UoM command je null");
                } else {
                    log.debug("UoM command id je: " + command.getUomCommand().getId());
                }*/
                UnitOfMeasure uom;
                uom = unitOfMeasureRepository
                        .findById(command.getUomCommand().getId())
                        .orElseThrow(() -> new RuntimeException(("UOM NOT FOUND")));
                ingredientFound.setUom(uom); //TODO happy path, treba sredit

            } else {
                //add new ingredient
                recipe.addIngredient(ingredientCommandToIngredient.convert(command));
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            return ingredientToIngredientCommand.convert(savedRecipe.getIngredients()
                    .stream().filter(recipeIngredients -> recipeIngredients
                            .getId()
                            .equals(command.getId()))
                    .findFirst()
                    .get());
        }

    }
}
