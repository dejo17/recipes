package hr.scorpiusmobile.recipes.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class RecipeToRecipeCommandTest {

    RecipeToRecipeCommand converter;
    @BeforeEach
    void setUp() {
        converter = new RecipeToRecipeCommand();
    }
    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    void convert() {
    }
}