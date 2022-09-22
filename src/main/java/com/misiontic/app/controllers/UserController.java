/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.User;
import com.misiontic.app.services.UserService;
import com.misiontic.app.util.PasswordHash;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cahuc
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<User> listarUsuarios() {
        return userService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public User consultarPorId(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<User> agregar(@RequestBody User user) {

        // cifrar la clave recibida y modificarla
        String claveCifrada = PasswordHash.cifrarPassword(user.getPassword());
        user.setPassword(claveCifrada);
        User result = userService.save(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<User> editar(@RequestBody User nuevo) {

        User actual = userService.findById(nuevo.getId_user());

        if (actual == null) {
            return new ResponseEntity<>(actual, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {

            // Si la clave cambió, modificarla
            actual.setId_user(nuevo.getId_user());
            actual.setName(nuevo.getName());

            if (!nuevo.getPassword().equals(actual.getPassword())) {
                String claveCifrada = PasswordHash.cifrarPassword(nuevo.getPassword());
                actual.setPassword(claveCifrada);
            }

            actual.setName(nuevo.getName());
            actual.setRole(nuevo.getRole());

            userService.save(actual);
            return new ResponseEntity<>(actual, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> eliminar(@PathVariable Integer id) {

        User result = userService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            userService.delete(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}
