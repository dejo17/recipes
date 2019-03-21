package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.CategoryCommand;
import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    IngredientToIngredientCommand converter;
    private final Long ID = 1L;
    private  final String DESCRIPTION ="description of ingredient";
    private final BigDecimal AMOUNT = BigDecimal.valueOf(2L);
    private final UnitOfMeasure uom = new UnitOfMeasure();
    private final Recipe recipe = new Recipe();

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        Long id = 1L;
        String description = "Some text";
        BigDecimal amount = BigDecimal.valueOf(1L);
        UnitOfMeasure uom = new UnitOfMeasure();
        assertNotNull(converter.convert(new Ingredient(description,amount, uom)));
    }

    @Test
    void convert() {
        Ingredient ingredient = new Ingredient(DESCRIPTION, AMOUNT, uom);
        ingredient.setId(ID);
        ingredient.setRecipe(recipe);
        IngredientCommand command = converter.convert(ingredient);
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(recipe, command.getRecipe());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(uom,command.getUom());
    }
}