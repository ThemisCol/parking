/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.Producto;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface ProductoService {

    public Producto save(Producto producto);

    public void delete(Integer id);

    public Producto findById(Integer id);

    public List<Producto> findAll();

    public Producto findByName(String name);

}
