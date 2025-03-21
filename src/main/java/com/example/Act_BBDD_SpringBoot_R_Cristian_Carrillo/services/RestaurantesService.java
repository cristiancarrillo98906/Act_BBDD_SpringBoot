package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RestaurantesModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories.IRestaurantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RestaurantesService implements IRestaurantesService{
    @Autowired
    IRestaurantesRepository restaurantesRepository;

    @Override
    public ArrayList<RestaurantesModel> getRestaurantes() {
        return (ArrayList<RestaurantesModel>) restaurantesRepository.findAll();
    }

    @Override
    public Optional<RestaurantesModel> getRestauranteById(Long id) {
        return restaurantesRepository.findById(id);
    }
}
