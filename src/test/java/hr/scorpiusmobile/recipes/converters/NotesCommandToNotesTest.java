package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.CategoryCommand;
import hr.scorpiusmobile.recipes.commands.NotesCommand;
import hr.scorpiusmobile.recipes.domain.Notes;
import hr.scorpiusmobile.recipes.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    NotesCommandToNotes converter;
    private final  String RECIPE_NOTES = "Some description to test";
    private final Long ID_VALUE = 1L;
    private  Recipe recipe;

    @BeforeEach
    void setUp() {
        converter = new NotesCommandToNotes();
        recipe=new Recipe();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    void convert() {
        NotesCommand command = new NotesCommand();
        command.setId(ID_VALUE);
        command.setRecipe(recipe);
        command.setRecipeNotes(RECIPE_NOTES);
        Notes note = converter.convert(command);
        assertEquals(ID_VALUE, note.getId());
        assertEquals(RECIPE_NOTES,note.getRecipeNotes());
        assertEquals(recipe,note.getRecipe());
    }
}