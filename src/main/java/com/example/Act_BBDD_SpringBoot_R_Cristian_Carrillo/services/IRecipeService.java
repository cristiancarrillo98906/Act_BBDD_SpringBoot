package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RecipeModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IRecipeService {
    ArrayList<RecipeModel> getRecetas();
    Optional<RecipeModel> getRecetaById(Long id);
    RecipeModel saveRecipe(RecipeModel recipe);
    RecipeModel editRecipe(RecipeModel recipe, Long id);
    Boolean deleteRecipe(Long id);
}
