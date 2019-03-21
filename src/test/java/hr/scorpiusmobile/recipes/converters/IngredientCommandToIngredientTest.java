package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientCommandToIngredientTest {

    IngredientCommandToIngredient converter;
    private final Long ID = 1L;
    private  final String DESCRIPTION ="description of ingredient";
    private final BigDecimal AMOUNT = BigDecimal.valueOf(2L);
    private final UnitOfMeasure uom = new UnitOfMeasure();
    private final Recipe recipe = new Recipe();
    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient();
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
        command.setRecipe(recipe);
        command.setUom(uom);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        Ingredient ingredient = converter.convert(command);
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(recipe, ingredient.getRecipe());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(uom,ingredient.getUom());

    }
}