package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.controllers;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.RestaurantesModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services.IRestaurantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public RestaurantesModel insertRestaurante(@RequestBody RestaurantesModel rest){
        return this.restaurantesService.saveRestaurante(rest);
    }

    @PutMapping("/{id}")
    public RestaurantesModel updateRestaurante(@RequestBody RestaurantesModel rest, @PathVariable Long id){
        return this.restaurantesService.editRestaurante(rest,id);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage deleteRestaurante(@PathVariable Long id){
        boolean eliminado = this.restaurantesService.deleteRestaurante(id);
        if(eliminado){
            return new ResponseMessage("Restaurante, con id: " + id + ", se ha eliminado con éxito");
        }else{
            return new ResponseMessage("Error al eliminar el restaurante con id: " + id);
        }
    }
}