/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.Producto;
import com.misiontic.app.services.ProductoService;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "/list")
    public List<Producto> listarProductos() {
        return productoService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public Producto consultarPorId(@PathVariable Integer id) {
        return productoService.findById(id);
    }

    @GetMapping(value = "/list/name/{name}")
    public Producto consultarPorId(@PathVariable String name) {
        return productoService.findByName(name);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Producto> agregar(@RequestBody Producto producto) {
        Producto result = productoService.save(producto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Producto> editar(@RequestBody Producto nuevo) {

        Producto actual = productoService.findById(nuevo.getIdProducto());

        if (actual == null) {
            return new ResponseEntity<>(actual, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            actual.setNombreProducto(nuevo.getNombreProducto());
            actual.setValorCompra(nuevo.getValorCompra());
            actual.setValorVenta(nuevo.getValorVenta());
            actual.setCantidad(nuevo.getCantidad());
            productoService.save(actual);
            return new ResponseEntity<>(actual, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Integer id) {

        Producto result = productoService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            productoService.delete(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}
