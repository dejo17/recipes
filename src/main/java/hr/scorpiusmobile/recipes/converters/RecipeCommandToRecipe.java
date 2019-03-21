package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.RecipeCommand;
import hr.scorpiusmobile.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }
        final Recipe recipe = new Recipe();
        return recipe;
    }
}
