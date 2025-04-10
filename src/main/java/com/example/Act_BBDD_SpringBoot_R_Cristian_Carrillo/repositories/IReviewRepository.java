package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<ReviewModel, Long> {
}
