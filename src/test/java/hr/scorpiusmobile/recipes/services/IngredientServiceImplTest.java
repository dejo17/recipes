package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.converters.IngredientCommandToIngredient;
import hr.scorpiusmobile.recipes.converters.IngredientToIngredientCommand;
import hr.scorpiusmobile.recipes.converters.UnitOfMeasureCommandToUnitOfMeasure;
import hr.scorpiusmobile.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import hr.scorpiusmobile.recipes.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

class IngredientServiceImplTest {

    IngredientService ingredientService;

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();
    IngredientToIngredientCommand ingredientToIngredientCommand = new IngredientToIngredientCommand(unitOfMeasureToUnitOfMeasureCommand);
    IngredientCommandToIngredient ingredientCommandToIngredient = new IngredientCommandToIngredient(unitOfMeasureCommandToUnitOfMeasure);


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ingredientService = new IngredientServiceImpl(recipeRepository, ingredientToIngredientCommand, ingredientCommandToIngredient,
                unitOfMeasureRepository);
    }

    @Test
    @Disabled
    void saveIngredientCommand() throws Exception{

        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe()); //to be returned by recipeRepository findById

        Recipe savedRecipe = new Recipe(); //to be returned by recipeRepository save method
        recipeOptional.get().addIngredient(new Ingredient());
        recipeOptional.get().getIngredients().iterator().next().setId(3L);

        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);
        //when
        IngredientCommand savedIngredientCommand = ingredientService.saveIngredientCommand(command);

        //then
        assertEquals(savedIngredientCommand.getId(), Long.valueOf(3L));
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }
}