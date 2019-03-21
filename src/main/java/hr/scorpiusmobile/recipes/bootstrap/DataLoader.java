package hr.scorpiusmobile.recipes.bootstrap;

import hr.scorpiusmobile.recipes.domain.*;
import hr.scorpiusmobile.recipes.repositories.CategoryRepository;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import hr.scorpiusmobile.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        //we create a list to populate and return
        List<Recipe> recipes = new ArrayList<>(2);

        //Retrieve unit of measures from database and create optional objects:
        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByDescription("teaspoon");
        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByDescription("tablespoon");
        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByDescription("dash");
        Optional<UnitOfMeasure> cloveOptional = unitOfMeasureRepository.findByDescription("clove");
        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByDescription("cup");
        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepository.findByDescription("pint");
        //check if records are found:
        if (!teaspoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }
        if (!tablespoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }
        if (!dashOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }
        if (!cloveOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }
        if (!cupOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }
        if (!pintOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }
        //Retrieve UnitOfMeasure object from Optional:
        UnitOfMeasure teaspoon = teaspoonOptional.get();
        UnitOfMeasure tablespoon = tablespoonOptional.get();
        UnitOfMeasure dash = dashOptional.get();
        UnitOfMeasure clove = cloveOptional.get();
        UnitOfMeasure cup = cupOptional.get();
        UnitOfMeasure pint = pintOptional.get();


        //Retrieve categories from database and create Optional objects:

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        Optional<Category> spicyCategoryOptional = categoryRepository.findByDescription("Spicy");
        //check if retrieval went well
        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }
        if (!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }
        if (!spicyCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }
        //retrieve Category objects from Optionals
        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category spicyCategory = spicyCategoryOptional.get();


        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setCookTime(14);
        guacamole.setPrepTime(22);
        guacamole.setServing(2);
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilies. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        guacamole.setDifficulty(Difficulty.MODERATE);
        guacamole.setUrl("www.scorpiusmobile.com");
        guacamole.getCategories().add(americanCategory);
        guacamole.getCategories().add(mexicanCategory);


        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        guacNotes.setRecipe(guacamole);
        guacamole.setNotes(guacNotes);

        recipes.add(guacamole);
        log.debug("Data loaded");
        return recipes;
    }
}
