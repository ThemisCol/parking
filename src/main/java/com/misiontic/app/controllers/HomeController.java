/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.Usuario;
import com.misiontic.app.services.UsuarioService;
import com.misiontic.app.util.PasswordHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cahuc
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "login")
    public ResponseEntity<Usuario> consultarLogin(@RequestBody Usuario usuario) {

        String claveCifrada = PasswordHash.cifrarPassword(usuario.getClave());

        Usuario result = usuarioService.findByCredentials(usuario.getIdUsuario(), claveCifrada);

        if (result == null) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}
