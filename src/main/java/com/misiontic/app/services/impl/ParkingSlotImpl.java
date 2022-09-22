/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.services.impl;

import com.misiontic.app.dao.ParkingSlotDao;
import com.misiontic.app.models.ParkingSlot;
import com.misiontic.app.services.ParkingSlotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cahuc
 */
@Service
public class ParkingSlotImpl implements ParkingSlotService {

    @Autowired
    private ParkingSlotDao parkingSlotDao;

    @Override
    @Transactional(readOnly = false)
    public ParkingSlot save(ParkingSlot parkingSlot) {
        return parkingSlotDao.save(parkingSlot);
    }

    @Override
    @Transactional(readOnly = true)
    public ParkingSlot findById(Integer id) {
        return parkingSlotDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParkingSlot> findAll() {
        return (List<ParkingSlot>) parkingSlotDao.findAll();
    }
}
