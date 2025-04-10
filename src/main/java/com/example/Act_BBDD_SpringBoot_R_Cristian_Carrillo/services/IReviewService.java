package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.ReviewModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IReviewService {
    ArrayList<ReviewModel> obtenerTodasReseñas();
    Optional<ReviewModel> obtenerReseñaPorId(Long id);
    ReviewModel saveReseña(ReviewModel review);
    ReviewModel editReseña(ReviewModel review, Long id);
    Boolean deleteReseña(Long id);
}
