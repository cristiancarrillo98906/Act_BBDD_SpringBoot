package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RestaurantesModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IRestaurantesService {
    ArrayList<RestaurantesModel> getRestaurantes();
    Optional<RestaurantesModel> getRestauranteById(Long id);
}
