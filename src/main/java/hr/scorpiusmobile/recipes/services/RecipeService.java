package hr.scorpiusmobile.recipes.services;

import java.util.Set;

public interface RecipeService<Recipe, Object extends Long> {

    Set<Recipe> getRecipes();
    Recipe findById(Object  id);


}
