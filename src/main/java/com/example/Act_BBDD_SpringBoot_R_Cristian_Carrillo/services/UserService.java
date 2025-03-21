package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.UserModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository; //JPA Hibernate


    @Override
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
