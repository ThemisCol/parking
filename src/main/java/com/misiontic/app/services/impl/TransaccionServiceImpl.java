/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.services.impl;

import com.misiontic.app.dao.TransaccionDao;
import com.misiontic.app.models.Transaccion;
import com.misiontic.app.services.TransaccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cahuc
 */
@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionDao transaccionDao;

    @Override
    @Transactional(readOnly = false)
    public Transaccion save(Transaccion transaccion) {
        return transaccionDao.save(transaccion);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        transaccionDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Transaccion findById(Integer id) {
        return transaccionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaccion> findAll() {
        return (List<Transaccion>) transaccionDao.findAll();
    }

}
