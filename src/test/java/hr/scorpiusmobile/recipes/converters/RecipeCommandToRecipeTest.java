package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.RecipeCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class RecipeCommandToRecipeTest {

    RecipeCommandToRecipe converter;
    @BeforeEach
    void setUp() {
        converter =new RecipeCommandToRecipe();
    }
    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new RecipeCommand()));
    }
    @Test
    void convert() {
    }
}