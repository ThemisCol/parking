/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.services.impl;

import com.misiontic.app.dao.DetalleDao;
import com.misiontic.app.dao.TransaccionDao;
import com.misiontic.app.models.Detalle;
import com.misiontic.app.models.Transaccion;
import com.misiontic.app.services.DetalleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cahuc
 */
@Service
public class DetalleServiceImpl implements DetalleService {

    @Autowired
    private DetalleDao detalleDao;

    @Autowired
    private TransaccionDao TransaccionDao;

    @Override
    public Detalle save(Detalle detalle) {
        return detalleDao.save(detalle);
    }

    @Override
    public void delete(Integer id) {
        detalleDao.deleteById(id);
    }

    @Override
    public Detalle findById(Integer id) {
        return detalleDao.findById(id).orElse(null);
    }

    @Override
    public List<Detalle> findAll() {
        return (List<Detalle>) detalleDao.findAll();
    }

    @Override
    public List<Detalle> findByTransaccion(Integer idTransaccion) {
        return (List<Detalle>) detalleDao.findAllByTransaccion_IdTransaccion(idTransaccion);
    }

}
