package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.NotesCommand;
import hr.scorpiusmobile.recipes.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {

   NotesToNotesCommand converter;
   private final  String RECIPE_NOTES = "Some description to test";
   private final Long ID_VALUE = 1L;
    @BeforeEach
    void setUp() {
        converter = new NotesToNotesCommand();
    }
    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Notes()));
    }
    @Test
    void convert() {
        Notes notes = new Notes();
        notes.setRecipeNotes(RECIPE_NOTES);
        notes.setId(ID_VALUE);
        NotesCommand notesCommand = converter.convert(notes);
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
        assertEquals(ID_VALUE,notesCommand.getId());
    }
}