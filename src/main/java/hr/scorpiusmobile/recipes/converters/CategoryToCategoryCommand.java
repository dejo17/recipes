package hr.scorpiusmobile.recipes.converters;

import hr.scorpiusmobile.recipes.commands.CategoryCommand;
import hr.scorpiusmobile.recipes.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null) {
            return null;
        }
        final CategoryCommand categoryCommand = new CategoryCommand();
        return categoryCommand;
    }
}
