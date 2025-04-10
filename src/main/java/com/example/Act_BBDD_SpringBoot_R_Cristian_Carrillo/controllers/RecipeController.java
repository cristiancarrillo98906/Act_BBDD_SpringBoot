package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.controllers;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RecipeModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services.IRecipeService;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/recetas")
public class RecipeController {

    @Autowired
    private IRecipeService recipeService;

    @GetMapping
    public ArrayList<RecipeModel> getAllRecipes() {
        return this.recipeService.getRecetas();
    }

    @GetMapping("/{id}")
    private Optional<RecipeModel> getRecetasById(@PathVariable Long id) {
        return this.recipeService.getRecetaById(id);
    }

    @PostMapping
    public RecipeModel insertRecipe(@RequestBody RecipeModel recip){
        return this.recipeService.saveRecipe(recip);
    }

    @PutMapping("/{id}")
    public RecipeModel updateRecipe(@RequestBody RecipeModel recip, @PathVariable Long id) {
        return this.recipeService.editRecipe(recip, id);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage deleteRecipe(@PathVariable Long id){
        boolean eliminado = this.recipeService.deleteRecipe(id);
        if(eliminado){
            return new ResponseMessage("Receta, con id: " + id + ", se ha eliminado con éxito");
        }else{
            return new ResponseMessage("Error al eliminar la receta con id: " + id);
        }
    }

}
