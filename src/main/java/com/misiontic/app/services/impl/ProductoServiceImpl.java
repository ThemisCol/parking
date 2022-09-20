/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.services.impl;

import com.misiontic.app.dao.ProductoDao;
import com.misiontic.app.models.Producto;
import com.misiontic.app.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cahuc
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = false)
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        productoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Integer id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public Producto findByName(String name) {
        return productoDao.findByNombreProducto(name);
    }

}
