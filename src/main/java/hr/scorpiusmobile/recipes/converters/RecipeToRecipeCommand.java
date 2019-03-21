package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.RecipeCommand;
import hr.scorpiusmobile.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }
        final RecipeCommand recipeCommand= new RecipeCommand();
        return recipeCommand;
    }
}
