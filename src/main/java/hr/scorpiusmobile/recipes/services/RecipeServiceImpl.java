package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {

       Optional<Recipe> recipeOptional = recipeRepository.findById(id);
       if(!recipeOptional.isPresent()){
           throw new RuntimeException("Recipe not found!");
       }
       return recipeOptional.get();
    }
}
