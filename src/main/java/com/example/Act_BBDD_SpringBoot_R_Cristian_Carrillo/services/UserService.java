package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.UserModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        UserModel usuarioNuevo = null;
        if (user.getPassword().length() > 8) {
            boolean mayuscula = false;
            boolean numero = false;
            boolean letraOsimbolo = false;
            boolean especial = false;

            Pattern special = Pattern.compile("[?!¡@¿.,´)]");
            Matcher hasSpecial = special.matcher(user.getPassword());
            char l;

            for (int i = 0; i < user.getPassword().length(); i++) {
                l = user.getPassword().charAt(i);

                if (Character.isDigit(l)) {
                    numero = true;
                }
                if (Character.isLetter(l)) {
                    letraOsimbolo = true;
                }
                if (Character.isUpperCase(l)) {
                    mayuscula = true;
                }
                if (hasSpecial.find()) {
                    especial = true;
                }
            }

            if (numero && mayuscula && letraOsimbolo && especial) {
                ArrayList<UserModel> usuario = this.getUsers();
                for (UserModel users : usuario) {
                    if (user.getUsername().equalsIgnoreCase(users.getUsername())) {
                        System.out.println("Ya existe");
                        return null;
                    }
                }
                userRepository.save(user);
                usuarioNuevo = user;
            }

        } else {
                System.out.println("La contraseña no cumple con lo mínimo requerido");
            }
        return usuarioNuevo;
    }

    @Override
    public UserModel editUser(UserModel userParam, Long id) {
        UserModel usuarioEditado = null;
        if (userParam.getPassword().length() > 8) {
            boolean mayuscula = false;
            boolean numero = false;
            boolean letraOsimbolo = false;
            boolean especial = false;

            Pattern special = Pattern.compile("[?!¡@¿.,´)]");
            Matcher hasSpecial = special.matcher(userParam.getPassword());
            char l;

            for (int i = 0; i < userParam.getPassword().length(); i++) {
                l = userParam.getPassword().charAt(i);

                if (Character.isDigit(l)) {
                    numero = true;
                }
                if (Character.isLetter(l)) {
                    letraOsimbolo = true;
                }
                if (Character.isUpperCase(l)) {
                    mayuscula = true;
                }
                if (hasSpecial.find()) {
                    especial = true;
                }
            }

            if (numero && mayuscula && letraOsimbolo && especial) {
                ArrayList<UserModel> usuario = this.getUsers();
                UserModel user = userRepository.findById(id).get();
                user.setName(userParam.getName());
                user.setLastname(userParam.getLastname());
                user.setEmail(userParam.getEmail());
                user.setPassword(userParam.getPassword());
                user.setProfile(userParam.getProfile());
                user.setUsername(userParam.getUsername());
                userRepository.save(user);
                usuarioEditado =user;
            }
        } else {
            System.out.println("La contraseña no cumple con lo mínimo requerido");
        }
        return usuarioEditado;
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
