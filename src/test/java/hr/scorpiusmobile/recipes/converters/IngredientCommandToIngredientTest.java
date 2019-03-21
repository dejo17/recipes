package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.CategoryCommand;
import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class IngredientCommandToIngredientTest {

    IngredientCommandToIngredient converter;

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
        IngredientCommand ingredientCommand = new IngredientCommand();

    }
}