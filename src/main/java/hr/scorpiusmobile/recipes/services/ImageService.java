package hr.scorpiusmobile.recipes.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService  {

    void saveImageFile(Long recipeId, MultipartFile imageMultipartFile);
}
