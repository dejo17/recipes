package hr.scorpiusmobile.recipes.converters;


import hr.scorpiusmobile.recipes.commands.CategoryCommand;
import hr.scorpiusmobile.recipes.domain.Category;
import hr.scorpiusmobile.recipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class CategoryCommandToCategoryTest {

    CategoryCommandToCategory converter;
    private final Long ID = 1L;
    private final String DESCRIPTION = "some description to test";
    private final Set<Recipe> recipes = new HashSet<>();

    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
        Recipe recipe1 = new Recipe();
        recipe1.setId(new Long(1));
        Recipe recipe2 = new Recipe();
        recipe2.setId(new Long(2));
        recipes.add(recipe1);
        recipes.add(recipe2);
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() {
        CategoryCommand command = new CategoryCommand();
        command.setDescription(DESCRIPTION);
        command.setId(ID);
        command.setRecipes(recipes);
        Category category = converter.convert(command);
        assertEquals(ID,category.getId());
        assertEquals(DESCRIPTION,category.getDescription());
        assertEquals(recipes, category.getRecipes());

    }
}