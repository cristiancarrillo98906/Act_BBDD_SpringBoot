package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepository extends JpaRepository<RecipeModel, Long> {
}
