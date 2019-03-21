package hr.scorpiusmobile.recipes.controllers;

import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
public class RecipeControllerTest {


    RecipeController recipeController;

    @Mock
    RecipeService recipeService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
       recipeController = new RecipeController(recipeService);
    }



    @Test
    public void testGetRecipe() throws Exception{

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        Long longId = new Long(1);
        when(recipeService.findById(longId)).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }
}