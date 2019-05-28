package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

class ImageServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    ImageService imageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        imageService = new ImageServiceImpl(recipeRepository);
    }

    @Test
    public void testSaveImageFile() throws Exception {

        Long recipeId = 1L;
        //we create multipart object as a text object for testing purposes
        MultipartFile imageMultipartFile =
                new MockMultipartFile("imageFile", "testing.text", "text/plain",
                        "Spring tutorial about image upload".getBytes());

        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        Optional recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);

        imageService.saveImageFile(recipeId, imageMultipartFile);

        verify(recipeRepository, times(1)).save(argumentCaptor.capture()); //verify save method is called and capture what is saved

        //now compare captured object with test object
        Recipe savedRecipe = argumentCaptor.getValue();

        assertEquals(imageMultipartFile.getBytes().length, savedRecipe.getImage().length);
    }
}