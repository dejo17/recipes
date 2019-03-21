package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.CategoryCommand;
import hr.scorpiusmobile.recipes.domain.Category;
import hr.scorpiusmobile.recipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryToCategoryCommandTest {

    CategoryToCategoryCommand converter;
    private final Long ID = 1L;
    private final String DESCRIPTION = "some description to test";
    private final Set<Recipe> recipes = new HashSet<>();

    @BeforeEach
    void setUp() {
         converter =new CategoryToCategoryCommand();
    }
    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }
    @Test
    void convert() {
        Category category = new Category();
        category.setDescription(DESCRIPTION);
        category.setId(ID);
        category.setRecipes(recipes);
        CategoryCommand categoryCommand = converter.convert(category);
        assertEquals(ID,categoryCommand.getId());
        assertEquals(DESCRIPTION,categoryCommand.getDescription());
        assertEquals(recipes, categoryCommand.getRecipes());
    }
}