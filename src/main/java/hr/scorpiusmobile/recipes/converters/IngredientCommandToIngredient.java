package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }
        final Ingredient ingredient = new Ingredient(source.getDescription(), source.getAmount(), source.getUom());
        ingredient.setRecipe(source.getRecipe());
        ingredient.setId(source.getId());
        return ingredient;
    }
}
