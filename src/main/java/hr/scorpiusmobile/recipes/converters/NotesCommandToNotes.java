package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.NotesCommand;
import hr.scorpiusmobile.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null) {
            return null;
        }
        final  Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipe(source.getRecipe());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
