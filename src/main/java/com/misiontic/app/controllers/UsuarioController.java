/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.Usuario;
import com.misiontic.app.services.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/list")
    public List<Usuario> listarUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public Usuario consultarPorId(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {

        // cifrar la clave recibida y modificarla
        String claveCifrada = PasswordHash.cifrarPassword(usuario.getClave());
        usuario.setClave(claveCifrada);
        Usuario result = usuarioService.save(usuario);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario nuevo) {

        Usuario actual = usuarioService.findById(nuevo.getId());

        if (actual == null) {
            return new ResponseEntity<>(actual, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {

            // Si la clave cambió, modificarla
            actual.setIdUsuario(nuevo.getIdUsuario());
            actual.setNombre(nuevo.getNombre());

            if (!nuevo.getClave().equals(actual.getClave())) {
                String claveCifrada = PasswordHash.cifrarPassword(nuevo.getClave());
                actual.setClave(claveCifrada);
            }

            actual.setNombre(nuevo.getNombre());
            actual.setTipo(nuevo.getTipo());
            actual.setEstado(nuevo.getEstado());

            usuarioService.save(actual);
            return new ResponseEntity<>(actual, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id) {

        Usuario result = usuarioService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            usuarioService.delete(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}
