package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.controllers;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.ReviewModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ArrayList<ReviewModel> obtenerTodos(){
        return reviewService.obtenerTodasReseñas();
    }

    @GetMapping("/{id}")
    public Optional<ReviewModel> obtenerReview(@PathVariable Long id){
        return reviewService.obtenerReseñaPorId(id);
    }

    @PostMapping
    public ReviewModel insertReview(@RequestBody ReviewModel reseña){
        return reviewService.saveReseña(reseña);
    }

    @PutMapping("/{id}")
    public ReviewModel editarReview(@RequestBody ReviewModel reseña, @PathVariable Long id){
        return reviewService.editReseña(reseña, id);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage elimarReview(@PathVariable Long id) {
        boolean eliminado=this.reviewService.deleteReseña(id);
        if (eliminado) {
            return new ResponseMessage("La reseña con ID "+id+", eliminado con exito");
        }else{
            return new ResponseMessage ("La reseña con ID "+id+" no se ha podido elimimar");
        }
    }
}
