/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.services.impl;

import com.misiontic.app.dao.VehicleBrandDao;
import com.misiontic.app.models.VehicleBrand;
import com.misiontic.app.services.VehicleBrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cahuc
 */
@Service
public class VehicleBrandServiceImpl implements VehicleBrandService {

    @Autowired
    private VehicleBrandDao vehicleBrandDao;

    @Override
    @Transactional(readOnly = true)
    public VehicleBrand findById(Integer id) {
        return vehicleBrandDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleBrand> findAll() {
        return (List<VehicleBrand>) vehicleBrandDao.findAll();
    }
}
