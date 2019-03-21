package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.CategoryCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class IngredientToIngredientCommandTest {

    IngredientToIngredientCommand converter;
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
       // assertNotNull(converter.convert(new Ingredient()));
    }
    @Test
    void convert() {
    }
}