package com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.controllers;

import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.models.UserModel;
import com.example.Act_BBDD_SpringBoot_R_Cristian_Carrillo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public UserModel insertUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable Long id){
        return this.userService.editUser(user,id);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage deleteModulo(@PathVariable Long id){
        boolean eliminado = this.userService.deleteUser(id);
        if(eliminado){
            return new ResponseMessage("Usuario, con id: " + id + ", se ha eliminado con éxito");
        }else{
            return new ResponseMessage("Error al eliminar el usuario con id: " + id);
        }
    }

}

class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

