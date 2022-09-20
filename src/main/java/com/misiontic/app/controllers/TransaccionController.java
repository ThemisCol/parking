/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.Transaccion;
import com.misiontic.app.services.TransaccionService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
@RequestMapping("/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping(value = "/list")
    public List<Transaccion> listarTransacciones() {
        return transaccionService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public Transaccion consultarPorId(@PathVariable Integer id) {
        return transaccionService.findById(id);
    }

    @PostMapping(value = "")
    public ResponseEntity<Transaccion> agregar(@RequestBody Transaccion transaccion) {
        Transaccion resultado = transaccionService.save(transaccion);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Transaccion> editar(@RequestBody Transaccion nuevo) {

        Transaccion actual = transaccionService.findById(nuevo.getIdTransaccion());

        if (actual == null) {
            ResponseEntity response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al editar, objeto no encontrado con Id:" + nuevo.getIdTransaccion());
            return response;
        } else {

            TimeZone tz = TimeZone.getTimeZone("GMT-5:00");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
            df.setTimeZone(tz);
            String nowAsISO = df.format(new Date());

            actual.setComprador(nuevo.getComprador());
            actual.setVendedor(nuevo.getVendedor());
            actual.setTipoTransaccion(nuevo.getTipoTransaccion());
            actual.setTotal(nuevo.getTotal());
            actual.setFechaTransaccion(nowAsISO);
            transaccionService.save(actual);
            return new ResponseEntity<>(actual, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Transaccion> eliminar(@PathVariable Integer id) {

        Transaccion actual = transaccionService.findById(id);

        if (actual == null) {
            ResponseEntity response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar, objeto no encontrado con Id:" + actual.getIdTransaccion());
            return response;
        } else {
            transaccionService.delete(id);
            return new ResponseEntity<>(actual, HttpStatus.OK);
        }

    }

}
