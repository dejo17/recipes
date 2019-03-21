package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.NotesCommand;
import hr.scorpiusmobile.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>
{
    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }
        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        notesCommand.setId(source.getId());
        notesCommand.setRecipe(source.getRecipe());
        return notesCommand;
    }
}
