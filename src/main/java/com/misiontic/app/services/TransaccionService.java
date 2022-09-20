/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.Transaccion;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface TransaccionService {

    public Transaccion save(Transaccion transaccion);

    public void delete(Integer id);

    public Transaccion findById(Integer id);

    public List<Transaccion> findAll();

}
