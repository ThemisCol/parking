/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.Detalle;
import com.misiontic.app.models.Transaccion;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface DetalleService {

    public Detalle save(Detalle detalle);

    public void delete(Integer id);

    public Detalle findById(Integer id);

    public List<Detalle> findAll();

    public List<Detalle> findByTransaccion(Integer idTransaccion);

}
