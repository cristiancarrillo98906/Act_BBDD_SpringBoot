package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.UserModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IUserService {
    ArrayList<UserModel> getUsers();
    Optional<UserModel> getUserById(Long id);
    UserModel saveUser (UserModel user);
    UserModel editUser (UserModel user, Long id);
    Boolean deleteUser (Long id);
}
