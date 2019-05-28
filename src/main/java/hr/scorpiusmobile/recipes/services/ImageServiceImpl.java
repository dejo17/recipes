package hr.scorpiusmobile.recipes.services;

import hr.scorpiusmobile.recipes.domain.Recipe;
import hr.scorpiusmobile.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{

    RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile imageMultipartFile) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(recipeOptional.isPresent()){

            try {

                Recipe recipe = recipeOptional.get();

                //converting primitive bytes to Byte object
                Byte[] byteObject = new Byte[imageMultipartFile.getBytes().length];
                int i=0;

                for(byte b:imageMultipartFile.getBytes()){
                    byteObject[i++]=b;
                }

                recipe.setImage(byteObject);
                recipeRepository.save(recipe);

            } catch (IOException e) {
                //TODO better error handling
                log.debug("Error occurred while saving image.");
                e.printStackTrace();
            }




        }

    }
}
