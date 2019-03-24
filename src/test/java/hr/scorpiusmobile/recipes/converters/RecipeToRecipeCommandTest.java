package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.RecipeCommand;
import hr.scorpiusmobile.recipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class RecipeToRecipeCommandTest {

    RecipeToRecipeCommand converter;
    @BeforeEach
    void setUp() {
        //converter = new RecipeToRecipeCommand();
    }
    @Test
    public void testNullParameter() throws Exception {
       // assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        //assertNotNull(converter.convert(new Recipe()));
    }
    @Test
    void convert() {
    }
}