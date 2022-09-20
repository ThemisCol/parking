/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.Detalle;
import com.misiontic.app.models.Transaccion;
import com.misiontic.app.services.DetalleService;
import com.misiontic.app.services.TransaccionService;
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
@RequestMapping("/detalle")
public class DetalleController {

    @Autowired
    private DetalleService detalleService;

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping(value = "/list")
    public List<Detalle> listarDetalles() {
        return detalleService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public Detalle consultarPorId(@PathVariable Integer id) {
        return detalleService.findById(id);
    }

    @GetMapping(value = "/transaccion/{id}")
    public ResponseEntity<List<Detalle>> consultarPorTransaccionId(@PathVariable Integer id) {

        List<Detalle> detalles = null;
        Transaccion transaccion = transaccionService.findById(id);

        if (transaccion == null) {
            return new ResponseEntity<>(detalles, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            detalles = detalleService.findByTransaccion(transaccion.getIdTransaccion());
            return new ResponseEntity<>(detalles, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<Detalle> agregar(@RequestBody Detalle detalle) {
        Detalle result = detalleService.save(detalle);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Detalle> editar(@RequestBody Detalle nuevo) {

        Detalle actual = detalleService.findById(nuevo.getIdDetalle());

        if (actual == null) {
            return new ResponseEntity<>(actual, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            actual.setProducto(nuevo.getProducto());
            actual.setTransaccion(nuevo.getTransaccion());
            actual.setValorDetalle(nuevo.getValorDetalle());
            actual.setCantidadDetalle(nuevo.getCantidadDetalle());
            actual.setTotalDetalle(nuevo.getValorDetalle() * nuevo.getCantidadDetalle());

            detalleService.save(actual);
            return new ResponseEntity<>(actual, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Detalle> eliminar(@PathVariable Integer id) {

        Detalle result = detalleService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            detalleService.delete(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}
