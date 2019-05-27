package hr.scorpiusmobile.recipes.controllers;

import hr.scorpiusmobile.recipes.commands.IngredientCommand;
import hr.scorpiusmobile.recipes.commands.RecipeCommand;
import hr.scorpiusmobile.recipes.services.IngredientService;
import hr.scorpiusmobile.recipes.services.RecipeService;
import hr.scorpiusmobile.recipes.services.UnitOfMeasureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class IngredientControllerTest {

    MockMvc mockMvc;

    @Mock
    RecipeService recipeService;
    @Mock
    IngredientService ingredientService;
    @Mock
    UnitOfMeasureService unitOfMeasureService;

    IngredientController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new IngredientController(recipeService, ingredientService, unitOfMeasureService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testIngredientList() throws Exception {

        RecipeCommand command = new RecipeCommand();
        command.setId(1L);
        when(recipeService.findCommandById(anyLong())).thenReturn(command);

        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredients/list"))
                .andExpect(model().attributeExists("recipe"));
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void testIngredientShow() throws Exception {
        IngredientCommand command = new IngredientCommand();
        command.setId(2L);

        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(command);

        mockMvc.perform(get("/recipe/1/ingredients/2/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredients/show"))
                .andExpect(model().attributeExists("ingredient"));
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        IngredientCommand command = new IngredientCommand();
        command.setId(2L);

        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(command);

        mockMvc.perform(get("/recipe/1/ingredients/2/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredients/ingredientform"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"));
    }

    @Test
    public void testNewIngredientForm() throws Exception {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        //then
        mockMvc.perform(get("/recipe/1/ingredients/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredients/ingredientform"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"));
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void testDeleteIngredient() throws Exception {


        mockMvc.perform(get("/recipe/1/ingredients/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/1/ingredients"));
        verify(ingredientService, times(1)).deleteById(anyLong(), anyLong());

    }

}