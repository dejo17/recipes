package hr.scorpiusmobile.recipes.commands;

import hr.scorpiusmobile.recipes.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;
    private String recipeNotes;
    private Recipe recipe;

}
