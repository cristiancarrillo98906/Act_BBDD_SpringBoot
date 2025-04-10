package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RecipeModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RecipeService implements IRecipeService{

    @Autowired
    IRecipeRepository recipeRepository;

    @Override
    public ArrayList<RecipeModel> getRecetas() {
        return (ArrayList<RecipeModel>) recipeRepository.findAll();
    }

    @Override
    public Optional<RecipeModel> getRecetaById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public RecipeModel saveRecipe(RecipeModel recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public RecipeModel editRecipe(RecipeModel recipe, Long id) {
        RecipeModel recip = recipeRepository.findById(id).get();
        recip.setTitulo(recipe.getTitulo());
        recip.setIngredientes(recipe.getIngredientes());
        recip.setInstrucciones(recipe.getInstrucciones());
        recipeRepository.save(recip);
        return recipe;
    }

    @Override
    public Boolean deleteRecipe(Long id) {
        try{
            recipeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
