package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.controllers;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RestaurantesModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services.IRestaurantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestaurantesController {
    @Autowired
    private IRestaurantesService restaurantesService;

    @GetMapping
    public ArrayList<RestaurantesModel> getAllRestaurantes(){
        return this.restaurantesService.getRestaurantes();
    }

    @GetMapping("/{id}")
    public Optional<RestaurantesModel> getRestauranteById(@PathVariable Long id){
        return this.restaurantesService.getRestauranteById(id);
    }
}
