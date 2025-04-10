package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.ReviewModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories.IRecipeRepository;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    IReviewRepository reviewRepository;

    @Override
    public ArrayList<ReviewModel> obtenerTodasReseñas() {
        return (ArrayList<ReviewModel>) reviewRepository.findAll();
    }

    @Override
    public Optional<ReviewModel> obtenerReseñaPorId(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public ReviewModel saveReseña(ReviewModel review) {
        return reviewRepository.save(review);
    }

    @Override
    public ReviewModel editReseña(ReviewModel review, Long id) {
        ReviewModel rev= reviewRepository.findById(id).get();
        rev.setComentario(review.getComentario());
        rev.setFecha(review.getFecha());
        rev.setIdRestaurante(review.getIdRestaurante());
        rev.setIdUsuario(review.getIdUsuario());
        rev.setValoracion(review.getValoracion());
        reviewRepository.save(rev);
        return rev;
    }

    @Override
    public Boolean deleteReseña(Long id) {
        try{
            reviewRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
