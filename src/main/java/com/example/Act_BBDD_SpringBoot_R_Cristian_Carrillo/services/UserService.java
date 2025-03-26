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

    @Override
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel editUser(UserModel userParam, Long id) {
        UserModel user = userRepository.findById(id).get();
        user.setName(userParam.getName());
        user.setLastname(userParam.getLastname());
        user.setEmail(userParam.getEmail());
        user.setPassword(userParam.getPassword());
        user.setProfile(userParam.getProfile());
        user.setUsername(userParam.getUsername());
        userRepository.save(user);
        return user;
    }

    @Override
    public Boolean deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
