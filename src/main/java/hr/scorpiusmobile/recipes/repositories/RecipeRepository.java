package hr.scorpiusmobile.recipes.repositories;

import hr.scorpiusmobile.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long > {
}
