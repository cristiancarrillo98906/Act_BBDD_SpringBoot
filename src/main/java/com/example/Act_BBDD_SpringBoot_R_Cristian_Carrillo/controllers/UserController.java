package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.controllers;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.UserModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ArrayList<UserModel> getAllUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return this.userService.getUserById(id);
    }
}
