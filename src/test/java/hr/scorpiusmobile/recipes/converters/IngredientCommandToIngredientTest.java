package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.commands.UnitOfMeasureCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import hr.scorpiusmobile.recipes.services.RecipeService;
import hr.scorpiusmobile.recipes.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientCommandToIngredientTest {


    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();

    RecipeServiceImpl recipeService;

    IngredientCommandToIngredient converter;

    private final Long ID = 1L;
    private final String DESCRIPTION = "description of ingredients";
    private final BigDecimal AMOUNT = BigDecimal.valueOf(2L);
    private final UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
    private final Recipe recipe = new Recipe();

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient(unitOfMeasureCommandToUnitOfMeasure);
        recipe.setId(1L);
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    void convert() {
        IngredientCommand command = new IngredientCommand();
        command.setId(ID);
        command.setRecipeId(recipe.getId());

        command.setUomCommand(uomCommand);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        Ingredient ingredient = converter.convert(command);
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        //todo assertEquals(recipe.getId(), ingredient.getRecipe());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertNotNull(ingredient.getUom());

    }
}